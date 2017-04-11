package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.OrganizationDAO;
public class OrganizationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");	
		if(new OrganizationDAO().checkReference(Integer.parseInt(id)))
			request.setAttribute("msgorg", "can not be deleted[chile record delete]");
		
		else	if(new OrganizationDAO().removeOrganization(Integer.parseInt(id)))
			request.setAttribute("msgorg", " successfully delete");
		
		else
			request.setAttribute("msgorg", " failed to delete");
		request.getRequestDispatcher("OrganizationListServlet").forward(request, response);
		
	}
}
