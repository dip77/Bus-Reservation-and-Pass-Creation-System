package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.StationDAO;

public class StationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stationid=request.getParameter("id");	
		
		if(new StationDAO().checkReference(Integer.parseInt(stationid)))
			request.setAttribute("msgstation", " can't be deleted[child record found]");
		else if(new StationDAO().removeStation(Integer.parseInt(stationid)))
			request.setAttribute("msgstation", " successfully delete");
		
		else
			request.setAttribute("msgstation", " failed to delete");
		request.getRequestDispatcher("StationListServlet").forward(request, response);
	
	}

}
