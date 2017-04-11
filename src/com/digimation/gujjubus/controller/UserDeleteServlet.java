package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.UserDAO;

public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("id");	
		if(new UserDAO().checkReference(Integer.parseInt(userid)))
			request.setAttribute("msguser", " can't be delete[child record found]");
		
		else if(new UserDAO().removeUser(Integer.parseInt(userid)))
			request.setAttribute("msguser", " successfully delete");
		
		else
			request.setAttribute("msguser", " failed to delete");
		request.getRequestDispatcher("UserListServlet").forward(request, response);

	}

}
