package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.PassTypeBean;
import com.digimation.gujjubus.dao.PassTypeDAO;
public class PassTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  passTypeid=request.getParameter("id");
		 PassTypeBean passTypeBeanObj =new PassTypeDAO().getPassTypeListByPK(Integer.parseInt(passTypeid));
		request.setAttribute("passTypeBean",passTypeBeanObj);
		request.getRequestDispatcher("PassTypeUpdate.jsp").forward(request, response);

	}

}
