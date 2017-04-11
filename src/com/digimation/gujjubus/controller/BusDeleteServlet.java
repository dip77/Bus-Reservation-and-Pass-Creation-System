package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.BusDAO;
public class BusDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busNo=request.getParameter("id");
		if(new BusDAO().checkReference(busNo))
			request.setAttribute("msgbus", " can't be deleted[record found]");
		else	if(new BusDAO().removeBus(busNo))
			request.setAttribute("msgbus", " successfully delete");
		else
			request.setAttribute("msgbus", " failed to delete");
		request.getRequestDispatcher("BusListServlet").forward(request, response);

	}

}
