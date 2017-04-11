package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusBean;
import com.digimation.gujjubus.dao.AdminDAO;
import com.digimation.gujjubus.dao.BusDAO;

public class AdminDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String adminid = request.getParameter("id");
		if (new AdminDAO().removeAdmin(Integer.parseInt(adminid)))
			request.setAttribute("msgadmin", " successfully delete");

		else
			request.setAttribute("msgadmin", " failed to delete");
		request.getRequestDispatcher("AdminListServlet").forward(request,
				response);

		

	}

}
