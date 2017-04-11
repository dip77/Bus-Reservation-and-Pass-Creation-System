package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.PassTypeDAO;
import com.digimation.gujjubus.dao.RouteDAO;
public class RouteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String routeid=request.getParameter("id");	
		if(new RouteDAO().checkReference(Integer.parseInt(routeid)))
			request.setAttribute("msgroute", " can't be  deleted[child record found]");
		else	if(new RouteDAO().removeRoute(Integer.parseInt(routeid)))
			request.setAttribute("msgroute", " successfully delete");
		
		else
			request.setAttribute("msgbuscat", " failed to delete");
		request.getRequestDispatcher("RouteListServlet").forward(request, response);
	
	}

}
