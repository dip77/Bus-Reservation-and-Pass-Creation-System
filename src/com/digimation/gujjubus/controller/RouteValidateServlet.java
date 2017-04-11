package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.RouteBean;
import com.digimation.gujjubus.dao.RouteDAO;
public class RouteValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String routeId=request.getParameter("id");
		String sourceId=request.getParameter("selsource");
		String destinationId=request.getParameter("seldestination");
		String isAvailable=request.getParameter("rdoavailable");
		RouteBean routeBean=new RouteBean();
	   routeBean.setRouteId(Integer.parseInt(routeId));
		routeBean.setDestinationId(Integer.parseInt(destinationId));
		routeBean.setSourceId(Integer.parseInt(sourceId));
		routeBean.setIsAvailable(isAvailable);
		if(new RouteDAO().updateRoute(routeBean))		
		{
			request.setAttribute("msgroute", "route successfully updated");
			request.getRequestDispatcher("RouteListServlet").forward(request, response);
		}
		
		else
		{
			request.setAttribute("msgroute"," failed to update route");
			request.getRequestDispatcher("RouteUpdate.jsp").forward(request, response);
		}
	
	}

}
