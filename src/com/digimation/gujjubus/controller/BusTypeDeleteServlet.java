package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.digimation.gujjubus.dao.BusTypeDAO;
import com.digimation.gujjubus.dao.PassTypeDAO;

public class BusTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busTypeid=request.getParameter("id");	
		if(new BusTypeDAO().checkReference(Integer.parseInt(busTypeid)))
			request.setAttribute("msgbustype", " can't be  deleted[child record found]");
		else if(new BusTypeDAO().removeBusType(Integer.parseInt(busTypeid)))
			request.setAttribute("msgbustype", " successfully delete");
		
		else
			request.setAttribute("msgbustype", " failed to delete");
		request.getRequestDispatcher("BusTypeListServlet").forward(request, response);

	}

}
