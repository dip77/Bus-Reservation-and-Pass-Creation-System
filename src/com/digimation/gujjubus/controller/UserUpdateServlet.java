package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.UserDAO;

public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("id");
		UserBean userBeanObj =new UserDAO().getUserListByPK(Integer.parseInt(userId));
		request.setAttribute("userBean",userBeanObj);
		request.getRequestDispatcher("UserUpdate.jsp").forward(request, response);
	}

}
