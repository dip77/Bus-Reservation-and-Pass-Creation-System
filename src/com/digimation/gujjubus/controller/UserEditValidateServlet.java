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

public class UserEditValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("id");
		String firstName=request.getParameter("txtfirstName");
		String password=request.getParameter("pwdpassword");
		String middleName=request.getParameter("txtmiddleName");
		String lastName=request.getParameter("txtlastName");
		String email=request.getParameter("txtemail");
		String gender=request.getParameter("rdogender");
		String address=request.getParameter("txtaddress");
		String mobile=request.getParameter("txtmobile");
		String cityId=request.getParameter("selcity");
		String isActive=request.getParameter("rdoactive");
		boolean isError=false;
		UserBean userBean=new UserBean();
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
		
		else
			userBean.setFirstName(firstName);

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
		else
			userBean.setMiddleName(middleName);
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
		else
			userBean.setLastName(lastName);
		if(ValidateUtils.isEmpty(email))
		{
			isError=true;
			request.setAttribute("msgemail", "please enter email");
		}
		else if(!ValidateUtils.EmailFormatValidator(email))
		{
			isError=true;
			userBean.setEmail(email);
			request.setAttribute("msgemail", "please enter valid email");
		}
	/*	else if(new UserDAO().isEmailExists(email))
		{
			isError=true;
			request.setAttribute("msgemail", "email already exists");
		}
	*/	else
			userBean.setEmail(email);
		if(ValidateUtils.isEmpty(mobile))
		{
			isError=true;
			request.setAttribute("msgmobile", "please enter mobile");
		}
		else if(!ValidateUtils.validateNumber(mobile))
		{
			isError=true;
			request.setAttribute("msgmobile", "please enter valid mobile no");
		}
		else
		userBean.setMobile(mobile);
		if(ValidateUtils.isEmpty(address))
		{
			isError=true;
			request.setAttribute("msgaddress", "please enter address");
		}
		else
			userBean.setAddress(address);
		userBean.setCityId(Integer.parseInt(cityId));
		userBean.setIsActive(isActive);
		userBean.setGender(gender);
		userBean.setPassword(password);
		if(isError)
		{
			
		request.setAttribute("userBean", userBean);
			request.getRequestDispatcher("UserEdit.jsp").forward(request, response);
		
		}
		else
		{
			
			userBean.setUserId(Integer.parseInt(userId));
			if(new UserDAO().updateUser(userBean))
			{
				HttpSession session=request.getSession();
				session.setAttribute("userBean", userBean);
				request.setAttribute("msguser", " successfully updated");
				request.getRequestDispatcher("UserHomePage.jsp").forward(request, response);
			
			}
			else
			{
				request.setAttribute("userBean", userBean);
				request.setAttribute("msguser", " failed to update ");
				request.getRequestDispatcher("UserEdit.jsp").forward(request, response);
				
			}
		}

	}

}
