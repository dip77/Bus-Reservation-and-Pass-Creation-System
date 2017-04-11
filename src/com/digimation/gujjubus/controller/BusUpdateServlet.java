package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusBean;
import com.digimation.gujjubus.dao.BusDAO;

public class BusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busNo=request.getParameter("id");
		BusBean busBeanObj =new BusDAO().getBusListByPK(busNo);
		request.setAttribute("busBean",busBeanObj);
		request.getRequestDispatcher("BusUpdate.jsp").forward(request, response);

	}

}
