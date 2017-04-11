package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusCategoryBean;
import com.digimation.gujjubus.dao.BusCategoryDAO;
public class BusCategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busCategoryId=request.getParameter("id");
		BusCategoryBean busCategoryBeanObj =new BusCategoryDAO().getBusCategoryListByPK(Integer.parseInt(busCategoryId));
		request.setAttribute("busCatBean",busCategoryBeanObj);
		request.getRequestDispatcher("BusCategoryUpdate.jsp").forward(request, response);

	}

}
