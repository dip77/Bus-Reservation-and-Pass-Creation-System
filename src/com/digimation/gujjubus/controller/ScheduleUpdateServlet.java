package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ScheduleBean;
import com.digimation.gujjubus.dao.ScheduleDAO;
public class ScheduleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scheduleId=request.getParameter("id");
		ScheduleBean scheduleBeanObj =new ScheduleDAO().getScheduleListByPK(Integer.parseInt(scheduleId));
		request.setAttribute("scheduleBean",scheduleBeanObj);
		request.getRequestDispatcher("ScheduleUpdate.jsp").forward(request, response);
	}

}
