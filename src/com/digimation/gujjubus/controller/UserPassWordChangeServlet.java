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
public class UserPassWordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPwd=request.getParameter("pwdoldpassword");
		String pwd=request.getParameter("pwdpassword");
		String cpwd=request.getParameter("pwdcpassword");
		boolean isError=false;
		HttpSession session=request.getSession();
	UserBean userBean=(UserBean)session.getAttribute("userBean");
	if(ValidateUtils.isEmpty(oldPwd))
	{
		isError=true;
		request.setAttribute("msgoldpassword","please enter old password");
	}
	else	if(!userBean.getPassword().equals(oldPwd))
		{
			isError=true;
			request.setAttribute("msgoldpassword","please enter correct old password");
		}
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
			request.getRequestDispatcher("UserChangePassword.jsp").forward(request, response);
		}
		else
		{
			 userBean= (UserBean)session.getAttribute("userBean");
			userBean.setPassword(ValidateUtils.base64encode(pwd));
			if(new UserDAO().changePassword(userBean))
			{
				request.setAttribute("msglogin", "password succesffully changed<br>login again to continue");
				request.getRequestDispatcher("UserLoginPage.jsp").forward(request, response);
				
			}
			else
			{
				request.getRequestDispatcher("UserChangePassword.jsp").forward(request, response);
			}
		}
	}

}
