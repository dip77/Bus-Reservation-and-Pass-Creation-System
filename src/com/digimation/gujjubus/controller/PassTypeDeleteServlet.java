package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.PassTypeDAO;
public class PassTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passTypeid=request.getParameter("id");	

		if(new PassTypeDAO().checkReference(Integer.parseInt(passTypeid)))
			request.setAttribute("msgpasstype", " can't be  deleted[child record found]");
		else if(new PassTypeDAO().removePassType(Integer.parseInt(passTypeid)))
			request.setAttribute("msgpasstype", " successfully delete");
		else
			request.setAttribute("msgpasstype", " failed to delete");
		request.getRequestDispatcher("PassTypeListServlet").forward(request, response);

	}

}
