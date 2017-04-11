package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.UserDAO;
import com.digimation.gujjubus.util.Email;
import com.digimation.gujjubus.util.ValidateUtils;

public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("txtemail");
		boolean isError=false;
		if(ValidateUtils.isEmpty(userName))
		{
			isError=true;
			request.setAttribute("username", "please enter username");
		}
		else if(!ValidateUtils.EmailFormatValidator(userName))
		{
			isError=true;
			request.setAttribute("username", "please enter valid email id");
		}
		else if(!new UserDAO().isEmailExists(userName))
		{
			isError=true;
			request.setAttribute("username", "please enter valid email id");
		}
		if(isError)
		{
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
		}
		else
		{
			
			String tmp="http://localhost:8080/BUSINDICATOR/ResetPassword.jsp?id="+
			ValidateUtils.base64encode(userName);
			String from="gujjubus2015@gmail.com";
			String password="SaurabhDip";
			String subject="forgot password";
			String message="please click below link to change your password "+tmp;
			String []to=new String[1];
					to[0]=userName;
					if(new Email().sendMail(from, password, subject, message, to))
					{
						request.setAttribute("msglogin","succesfully send to " +
								"your email<br>please check your email<br>");
						request.getRequestDispatcher("UserLoginPage.jsp").forward(request, response);
					}
					else
					{
						request.setAttribute("msglogin","failed!please try again");
						request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
					
					}
		
		}
	}

}
