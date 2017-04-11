package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.UserDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class UserPassWordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd=request.getParameter("pwdpassword");
		String cpwd=request.getParameter("pwdcpassword");
		String id=request.getParameter("id");
		boolean isError=false;
		if(ValidateUtils.isEmpty(pwd))
		{
			isError=true;
			request.setAttribute("msgpassword","please enter password");
		}
		else if(pwd!=null && pwd.length()<6)
		{
			isError=true;
			request.setAttribute("msgpassword","password must contain 6 character ");
		}
		if(ValidateUtils.isEmpty(cpwd))
		{
			isError=true;
			request.setAttribute("msgcpassword","please enter confirm password");
		}
		else if(pwd!=null && !pwd.equals(cpwd))
		{
			isError=true;
			request.setAttribute("msgcpassword","confirm password does not match");
		}
		if(isError)
		{
			request.getRequestDispatcher("ResetPassword.jsp").forward(request, response);
		}
		else
		{
			UserBean userBean=new UserBean();
			userBean.setPassword(ValidateUtils.base64encode(pwd));
			userBean.setEmail(ValidateUtils.base64decode(id));
			if(new UserDAO().resetPassword(userBean))
			{
				request.setAttribute("msglogin", "password succesffully changed<br>login again to continue");
				request.getRequestDispatcher("UserLoginPage.jsp").forward(request, response);
				
			}
			else
			{
				request.getRequestDispatcher("ResetPassword.jsp").forward(request, response);
			}
		}

	}
}
