package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.ScheduleDetailDAO;

public class ScheduleDetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scheduleDetailid=request.getParameter("id");	
		if(new ScheduleDetailDAO().removeScheduleDetail(Integer.parseInt(scheduleDetailid)))
			request.setAttribute("msgscheduledetail", " successfully delete");
		
		else
			request.setAttribute("msgscheduledetail", " failed to delete");
		request.getRequestDispatcher("ScheduleDetailListServlet").forward(request, response);
	
	}

}
