package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ScheduleDetailBean;
import com.digimation.gujjubus.dao.RouteDAO;
import com.digimation.gujjubus.dao.ScheduleDAO;
import com.digimation.gujjubus.dao.ScheduleDetailDAO;
import com.digimation.gujjubus.dao.StationDAO;

public class UserScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source=request.getParameter("Source");
		String destination=request.getParameter("Destination");
		boolean isError=false;
		if(source=="")
		{
			request.setAttribute("msgsource","enter source");
			isError=true;
		}
		if(destination=="")
		{
			request.setAttribute("msgdestination","enter destination");
			isError=true;
		}
		if(isError)
		{
			request.getRequestDispatcher("UserHomePage.jsp").forward(request, response);
		}
		else
		{
				int sourceId=new ScheduleDetailDAO().getStationId(source);
				int destinationId=new ScheduleDetailDAO().getStationId(destination); 
				ArrayList<ScheduleDetailBean> scheduleDetailBeans=new ScheduleDAO().
						getUserScheduleDetailList(sourceId, destinationId);
				request.setAttribute("scheduleDetailBeans",scheduleDetailBeans);
				request.getRequestDispatcher("UserScheduleList.jsp").forward(request, response);
		}
	}

}
