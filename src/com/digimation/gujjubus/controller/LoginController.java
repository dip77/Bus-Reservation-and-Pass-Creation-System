package com.digimation.gujjubus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.AdminBean;
import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.UserDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
}	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("txtemail");
		String password = request.getParameter("pwdpassword");
		boolean isError = false;
		if(ValidateUtils.isEmpty(userName))
		{
			isError=true;
			request.setAttribute("username", "please enter username");
		}
		else if(!ValidateUtils.EmailFormatValidator(userName))
		{
			isError=true;
			request.setAttribute("usrname", "please enter valid email id");
		}
		if(ValidateUtils.isEmpty(password))
		{
			isError=true;
			request.setAttribute("password", "please enter password");
		}
		if (isError) {

				request.getRequestDispatcher("UserLoginPage.jsp").forward(request, response);
		} else 
		{
		
			Object obj=new UserDAO().checkUser(userName,password);
			if (obj==null) 
			{
					System.out.println("wrong username or passwordd");	
					request.setAttribute("msguser", "please enter valid username or password");
					request.getRequestDispatcher("UserLoginPage.jsp").forward(request, response);
			}
			else if(obj instanceof UserBean)
			{
				HttpSession session = request.getSession();
				UserBean user = (UserBean)obj;
				session.setAttribute("userBean", user);
				System.out.println(session.getAttribute("scheduleDetailBean"));
				if(session.getAttribute("scheduleDetailBean")!=null)
				{
					response.sendRedirect("UserReservationInsert.jsp");
				}
				else
				{
					System.out.println("user");
					response.sendRedirect("UserHomePage.jsp");	
				}
			}	
			else	
			{
				System.out.println("admin"); 
				AdminBean admin=(AdminBean)obj;
				HttpSession session = request.getSession();
				session.setAttribute("AdminBean", admin);
				response.sendRedirect("Admindashboard.jsp");

			}
		}

	}
}
