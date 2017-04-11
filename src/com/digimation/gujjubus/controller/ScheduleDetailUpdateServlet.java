package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ScheduleDetailBean;
import com.digimation.gujjubus.dao.ScheduleDetailDAO;

public class ScheduleDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scheduleDetailId=request.getParameter("id");
		ScheduleDetailBean scheduleDetailBeanObj =new ScheduleDetailDAO().getScheduleDetailListByPK(Integer.parseInt(scheduleDetailId));
		request.setAttribute("scheduleDetailBean",scheduleDetailBeanObj);
		request.getRequestDispatcher("ScheduleDetailUpdate.jsp").forward(request, response);
	}

}
