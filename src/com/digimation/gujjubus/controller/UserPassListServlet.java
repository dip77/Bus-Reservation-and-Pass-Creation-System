package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.PassDAO;
import com.digimation.gujjubus.dao.PassDetailDAO;

public class UserPassListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserBean userBean=(UserBean)session.getAttribute("userBean");
		int id=userBean.getUserId();
		ArrayList<PassDetailBean> passDetailBeans= new PassDetailDAO().getPassDetailListbyUserId(id);
		session.setAttribute("passDetailBean", passDetailBeans);
		response.sendRedirect("UserPassList.jsp");
	}

}
