package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.dao.PassDetailDAO;
public class PassDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String passId=request.getParameter("id");
		ArrayList<PassDetailBean> listOfPassBeans=new PassDetailDAO().getPassDetailList(Integer.parseInt(passId));
		request.setAttribute("listofpassdetail", listOfPassBeans);
		request.getRequestDispatcher("PassDetailList.jsp").forward(request, response);
		

	}

}
