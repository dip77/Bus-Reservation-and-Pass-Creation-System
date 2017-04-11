package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusDetailBean;
import com.digimation.gujjubus.dao.BusDetailDAO;

public class BusDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String busDetailId=request.getParameter("id");
		BusDetailBean busDetailBeanObj =new BusDetailDAO().getBusDetailListByPK(Integer.parseInt(busDetailId));
		request.setAttribute("busDetailBean",busDetailBeanObj);
		request.getRequestDispatcher("BusDetailUpdate.jsp").forward(request, response);
	}

}
