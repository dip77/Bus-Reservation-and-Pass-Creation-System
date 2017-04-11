package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.bean.ScheduleBean;
import com.digimation.gujjubus.dao.PassDetailDAO;
import com.digimation.gujjubus.dao.ScheduleDAO;
public class PassDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passDetailId=request.getParameter("id");
		PassDetailBean passDetailBeanObj =new PassDetailDAO().getPassDetailListByPK(Integer.parseInt(passDetailId));
		request.setAttribute("passDetailBean",passDetailBeanObj);
		request.getRequestDispatcher("PassDetailUpdate.jsp").forward(request, response);	
	
	}

}
