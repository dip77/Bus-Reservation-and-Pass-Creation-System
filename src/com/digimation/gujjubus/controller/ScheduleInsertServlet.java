package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ScheduleBean;
import com.digimation.gujjubus.dao.ScheduleDAO;
public class ScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busNo=request.getParameter("selbusNo");
		boolean isError=false;
		if(busNo.equals("0"))
		{
			request.setAttribute("msgdes", "please select bus no");
			isError=true;
		}
		if(isError)
		{
			request.getRequestDispatcher("ScheduleDetailInsert.jsp").forward(request, response);
		}
		else
		{
			ScheduleBean scheduleBeanObj=new ScheduleBean();
			scheduleBeanObj.setBusNo(busNo);
			if(new ScheduleDAO().addSchedule(scheduleBeanObj))
			{
				request.setAttribute("msgschedule", busNo+"successfully added");
				request.getRequestDispatcher("ScheduleListServlet").forward(request, response);
				
			}
			else
			{
				request.setAttribute("msgschedule", busNo+" not added");
				request.getRequestDispatcher("ScheduleDetailInsert.jsp").forward(request, response);
				
			}
		}
		
	}

}
