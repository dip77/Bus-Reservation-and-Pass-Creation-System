package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.PassBean;
import com.digimation.gujjubus.dao.PassDAO;

public class PassUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passId=request.getParameter("id");
		PassBean passBeanObj =new PassDAO().getPassListByPK(Integer.parseInt(passId));
		request.setAttribute("passBean",passBeanObj);
		request.getRequestDispatcher("PassUpdate.jsp").forward(request, response);

	}

}
