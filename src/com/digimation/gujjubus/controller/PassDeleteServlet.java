package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.PassDAO;
public class PassDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passid=request.getParameter("id");	
		if(new PassDAO().removePass(Integer.parseInt(passid)))
			request.setAttribute("msgpass", " successfully delete");
		
		else
			request.setAttribute("msgpass", " failed to delete");
		request.getRequestDispatcher("PassListServlet").forward(request, response);
	}

}
