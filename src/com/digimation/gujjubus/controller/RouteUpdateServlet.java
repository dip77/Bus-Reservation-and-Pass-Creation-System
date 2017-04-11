package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.RouteBean;
import com.digimation.gujjubus.dao.RouteDAO;
public class RouteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String routeId=request.getParameter("id");
		RouteBean routeBeanObj =new RouteDAO().getRouteListByPK(Integer.parseInt(routeId));
		request.setAttribute("routeBean",routeBeanObj);
		request.getRequestDispatcher("RouteUpdate.jsp").forward(request, response);

	}

}
