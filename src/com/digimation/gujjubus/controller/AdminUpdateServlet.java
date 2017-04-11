package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.AdminBean;
import com.digimation.gujjubus.dao.AdminDAO;
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String adminId=request.getParameter("id");
	AdminBean adminBeanObj =new AdminDAO().getAdminListByPK(Integer.parseInt(adminId));
	request.setAttribute("adminBean",adminBeanObj);
	request.getRequestDispatcher("AdminUpdate.jsp").forward(request, response);
}

}
