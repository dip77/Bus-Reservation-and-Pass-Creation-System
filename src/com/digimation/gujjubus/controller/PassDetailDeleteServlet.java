package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.PassDetailDAO;

public class PassDetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminid=request.getParameter("id");	
		if(new PassDetailDAO().removePassDetail(Integer.parseInt(adminid)))
			request.setAttribute("msgpassdetail", " successfully delete");
		
		else
			request.setAttribute("msgpassdetail", " failed to delete");
		request.getRequestDispatcher("PassDetailListServlet").forward(request, response);
		
	}

}
