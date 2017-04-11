package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.AdminBean;
import com.digimation.gujjubus.dao.AdminDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class AdminInsertServlet extends HttpServlet {
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
		String password=request.getParameter("pwdpassword");
		String confirmPassword=request.getParameter("pwdcpassword");
		String cityId=request.getParameter("selcity");
		boolean isError=false;
		if(ValidateUtils.isEmpty(firstName))
		{
			isError=true;
			request.setAttribute("msgfirstname", "* First name");
		}
		else if(ValidateUtils.validateText(lastName))
		{
			isError=true;
			request.setAttribute("msglastname", "*Last name");
		}
		if(ValidateUtils.isEmpty(middleName))
		{
			isError=true;
			request.setAttribute("msgmiddlename", "*Middle name");
		}else if(ValidateUtils.validateText(middleName))
		{
			isError=true;
			request.setAttribute("msgmiddlename", "* Middle name");
		}

		if(ValidateUtils.isEmpty(lastName))
		{
			isError=true;
			request.setAttribute("msglastname", "*Last name");
		}
		else if(ValidateUtils.validateText(lastName))
		{
			isError=true;
			request.setAttribute("msglastname", "*Last name");
		}
		if(ValidateUtils.isEmpty(email))
		{
			isError=true;
			request.setAttribute("msgemail", "* Email");
		}
		else if(!ValidateUtils.EmailFormatValidator(email))
		{
			isError=true;
			request.setAttribute("msgemail", "*Email");
		}
		
		if(ValidateUtils.isEmpty(password))
		{
			isError=true;
			request.setAttribute("msgpassword", "*Password");
		}
		else if(password!=null && password.length()<6)
		{
			isError=true;
			request.setAttribute("msgpassword", "password must contain min. 6 character");
		}
	
			if(ValidateUtils.isEmpty(confirmPassword))
		{
			isError=true;
			request.setAttribute("msgcpassword", "*confirm password");
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
			request.getRequestDispatcher("AdminInsert.jsp").forward(request, response);
		}
		else
		{
			AdminBean adminBean=new AdminBean();
			adminBean.setCityId(Integer.parseInt(cityId));
			adminBean.setEmail(email);
			adminBean.setFirstName(firstName);
			adminBean.setLastName(lastName);
			adminBean.setMiddleName(middleName);
			adminBean.setGender(gender);
			adminBean.setPassword(ValidateUtils.base64encode(password));
			if(new AdminDAO().addAdmin(adminBean))
			{
				request.setAttribute("msgadmin", firstName+" successfully added");
				request.getRequestDispatcher("AdminListServlet").forward(request, response);
			
			}
			else
			{
				request.setAttribute("msgadmin", " failed to add "+firstName);
				request.getRequestDispatcher("AdminInsert.jsp").forward(request, response);
			
			}
		}
		

	}

}
