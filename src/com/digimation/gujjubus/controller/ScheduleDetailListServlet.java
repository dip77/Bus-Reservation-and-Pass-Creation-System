package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ScheduleDetailBean;
import com.digimation.gujjubus.dao.ScheduleDetailDAO;
public class ScheduleDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ScheduleDetailBean> listOfScheduleDetailBeans=new ScheduleDetailDAO().getscheduleDetailList();
		request.setAttribute("listofscheduledetail", listOfScheduleDetailBeans);
		request.getRequestDispatcher("ScheduleDetailList.jsp").forward(request, response);
	}

}
