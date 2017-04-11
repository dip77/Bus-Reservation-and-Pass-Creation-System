package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.UserDAO;
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession();
UserBean userBean= (UserBean)session.getAttribute("userBean");
		UserBean userBeanObj =new UserDAO().getUserListByPK(userBean.getUserId());
		request.setAttribute("userBean",userBeanObj);
		request.getRequestDispatcher("UserEdit.jsp").forward(request, response);
	}

}
