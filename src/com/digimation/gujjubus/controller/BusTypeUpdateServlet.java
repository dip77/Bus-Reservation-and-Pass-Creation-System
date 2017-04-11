package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean. BusTypeBean;
import com.digimation.gujjubus.dao. BusTypeDAO;

public class BusTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  busTypeid=request.getParameter("id");
		 BusTypeBean busCategoryBeanObj = new BusTypeDAO().getBusTypeListByPK(Integer.parseInt( busTypeid));
		request.setAttribute("busTypeBean",busCategoryBeanObj);
		request.getRequestDispatcher("BusTypeUpdate.jsp").forward(request, response);

	}
}
