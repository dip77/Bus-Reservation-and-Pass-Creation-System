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

public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("txtfirstName");
		String middleName=request.getParameter("txtmiddleName");
		String lastName=request.getParameter("txtlastName");
		String email=request.getParameter("txtemail");
		String gender=request.getParameter("rdogender");
		String address=request.getParameter("txtaddress");
		String password=request.getParameter("pwdpassword");
		String confirmPassword=request.getParameter("pwdcpassword");
		String mobile=request.getParameter("txtmobile");
		String cityId=request.getParameter("selcity");
		String id=request.getParameter("id");
		boolean isError=false;
		if(ValidateUtils.isEmpty(firstName))
		{
			isError=true;
			request.setAttribute("msgfirstname", "please enter first name");
		}
		else if(ValidateUtils.validateText(firstName))
		{
			isError=true;
			request.setAttribute("msgfirstname", "please enter valid first name");
		}
		if(ValidateUtils.isEmpty(middleName))
		{
			isError=true;
			request.setAttribute("msgmiddlename", "please enter middle name");
		}
		else if(ValidateUtils.validateText(middleName))
		{
			isError=true;
			request.setAttribute("msgmiddlename", "please enter valid first name");
		}
		if(ValidateUtils.isEmpty(lastName))
		{
			isError=true;
			request.setAttribute("msglastname", "please enter last name");
		}
		else if(ValidateUtils.validateText(lastName))
		{
			isError=true;
			request.setAttribute("msglastname", "please enter valid last name");
		}

		if(ValidateUtils.isEmpty(email))
		{
			isError=true;
			request.setAttribute("msgemail", "please enter email");
		}
		else if(!ValidateUtils.EmailFormatValidator(email))
		{
			isError=true;
			request.setAttribute("msgemail", "please enter valid email");
		}
		else if(new UserDAO().isEmailExists(email))
		{
			isError=true;
			request.setAttribute("msgemail", "email already exists");
		}
		if(ValidateUtils.isEmpty(mobile))
		{
			isError=true;
			request.setAttribute("msgmobile", "please enter mobile");
		}
		else if(!(ValidateUtils.validateNumber(mobile)) || mobile.length()!=10 )
		{
			isError=true;
			request.setAttribute("msgmobile", "please enter valid mobile no");
		}
		
		if(ValidateUtils.isEmpty(address))
		{
			isError=true;
			request.setAttribute("msgaddress", "please enter address");
		}
		
		if(ValidateUtils.isEmpty(password))
		{
			isError=true;
			request.setAttribute("msgpassword", "please enter password");
		}
		else if(password!=null && password.length()<6)
		{
			isError=true;
			request.setAttribute("msgpassword", " password must contain min 6 character");
		}	
		if(ValidateUtils.isEmpty(confirmPassword))
		{
			isError=true;
			request.setAttribute("msgcpassword", "please enter confirm password");
		}
		
		else if(password!=null && !password.equals(confirmPassword))
		{
			isError=true;
			request.setAttribute("msgcpassword", "confirm password does not match");
		}
		if(gender==null)
		{
			isError=true;
			request.setAttribute("msggender", "please select gender");
			
		}
		if(Integer.parseInt(cityId)==0)
		{
			isError=true;
			request.setAttribute("msgcity", "please select city");
			
		}
		if(isError)
		{
			if(id!=null && id.equals("user"))
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			else
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
		}
		else
		{
			UserBean userBean=new UserBean();
			userBean.setAddress(address);
			userBean.setCityId(Integer.parseInt(cityId));
			userBean.setEmail(email);
			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setMiddleName(middleName);
			userBean.setGender(gender);
			userBean.setPassword(ValidateUtils.base64encode(password));
			userBean.setMobile(mobile);
			if(new UserDAO().addUser(userBean))
			{
				if(id!=null && id.equals("user"))
				{
					HttpSession session=request.getSession();
					session.setAttribute("userBean", userBean);
					response.sendRedirect("UserHomePage.jsp");
				}
				else{
				request.setAttribute("msguser", firstName+" successfully added");
				request.getRequestDispatcher("UserListServlet").forward(request, response);
				}
			
			}
			else
			{
				if(id!=null && id.equals("user"))
					response.sendRedirect("SignUp.jsp");
				else{
				request.setAttribute("msguser", " failed to add "+firstName);
				request.getRequestDispatcher("Registration.jsp").forward(request, response);
				}
			
			}
		}
		
		
		
		
	}

}
