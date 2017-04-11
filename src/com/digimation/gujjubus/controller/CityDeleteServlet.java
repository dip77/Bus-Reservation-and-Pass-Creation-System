package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.CityDAO;
public class CityDeleteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");	
	if(new CityDAO().checkReference(Integer.parseInt(id)))
			request.setAttribute("msgcity", "can't be deleted [child record found]");
	else if(new CityDAO().removeCity(Integer.parseInt(id)))
			request.setAttribute("msgcity", " successfully delete");
		else
			request.setAttribute("msgcity", " failed to delete");
		request.getRequestDispatcher("CityListServlet").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
