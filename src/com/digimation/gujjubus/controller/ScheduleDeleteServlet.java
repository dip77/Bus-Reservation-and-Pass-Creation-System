package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.ScheduleDAO;

public class ScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scheduleid=request.getParameter("id");	
		if(new ScheduleDAO().removeSchedule(Integer.parseInt(scheduleid)))
			request.setAttribute("msgschedule", " successfully delete");
		
		else
			request.setAttribute("msgschedule", " failed to delete");
		request.getRequestDispatcher("ScheduleListServlet").forward(request, response);
	
	}

}
