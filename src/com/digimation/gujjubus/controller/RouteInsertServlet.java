package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.RouteBean;
import com.digimation.gujjubus.dao.RouteDAO;
public class RouteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String sourceId=request.getParameter("selsource");
String destinationId=request.getParameter("seldestination");
boolean isError=false;
if(Integer.parseInt(destinationId)==0)
{
	request.setAttribute("msgdes", "please select destination");
	isError=true;
}
if(Integer.parseInt(sourceId)==0)
{
	request.setAttribute("msgsource", "please select source");
	isError=true;
}
if(isError || new RouteDAO().isExists(Integer.parseInt(sourceId), Integer.parseInt(destinationId)))
{
	request.setAttribute("msgroute", "this route already exists");
	request.getRequestDispatcher("RouteInsert.jsp").forward(request, response);
}
else
{	
	RouteBean routeBean=new RouteBean();	
	routeBean.setDestinationId(Integer.parseInt(destinationId));
	routeBean.setSourceId(Integer.parseInt(sourceId));
	if(new RouteDAO().addRoute(routeBean))
	{
		request.setAttribute("msgroute", "route successfully added");
		request.getRequestDispatcher("RouteListServlet").forward(request, response);
	}
	
	else
	{
		request.setAttribute("msgroute"," failed to add route");
		request.getRequestDispatcher("RouteInsert.jsp").forward(request, response);
	}
}
	
}

	}


