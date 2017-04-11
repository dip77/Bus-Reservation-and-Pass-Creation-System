package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.AdminBean;
import com.digimation.gujjubus.dao.AdminDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class AdminValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminId=request.getParameter("id");
		String firstName=request.getParameter("txtfirstName");
		String password=request.getParameter("pwdpassword");
		String middleName=request.getParameter("txtmiddleName");
		String lastName=request.getParameter("txtlastName");
		String email=request.getParameter("txtemail");
		String gender=request.getParameter("rdogender");
		String cityId=request.getParameter("selcity");
		String isActive=request.getParameter("rdoactive");
		boolean isError=false;
		AdminBean adminBean=new AdminBean();
		if(ValidateUtils.isEmpty(firstName))
		{
			isError=true;
			request.setAttribute("msgfirstname", "please enter first name");
		}
		else if(ValidateUtils.validateText(firstName))
		{
			adminBean.setFirstName(firstName);
			isError=true;
			request.setAttribute("msgfirstname", "please enter valid first name");
		}
		else
			adminBean.setFirstName(firstName);

		if(ValidateUtils.isEmpty(middleName))
		{
			isError=true;
			request.setAttribute("msgmiddlename", "please enter middle name");
		}
		else if(ValidateUtils.validateText(middleName))
		{
			adminBean.setMiddleName(middleName);
			isError=true;
			request.setAttribute("msgfirstname", "please enter valid first name");
		}
		else
			adminBean.setMiddleName(middleName);
		if(ValidateUtils.isEmpty(lastName))
		{
			isError=true;
			request.setAttribute("msglastname", "please enter last name");
		}
		else if(ValidateUtils.validateText(lastName))
		{
			adminBean.setLastName(lastName);
			isError=true;
			request.setAttribute("msglastname", "please enter valid last name");
		}
		else
			adminBean.setLastName(lastName);
		if(ValidateUtils.isEmpty(email))
		{
			isError=true;
			request.setAttribute("msgemail", "please enter email");
		}
		else if(!ValidateUtils.EmailFormatValidator(email))
		{
			adminBean.setEmail(email);
			isError=true;
			request.setAttribute("msgemail", "please enter valid email");
		}
		else
			adminBean.setEmail(email);
		adminBean.setCityId(Integer.parseInt(cityId));
		adminBean.setIsActive(isActive);
		adminBean.setGender(gender);
		adminBean.setPassword(password);
		if(isError)
		{
		request.setAttribute("adminBean", adminBean);
			request.getRequestDispatcher("AdminUpdate.jsp").forward(request, response);
		
		}
		else
		{
			
			adminBean.setAdminId(Integer.parseInt(adminId));
			if(new AdminDAO().updateAdmin(adminBean))
			{
				request.setAttribute("msgadmin", " successfully updated");
				request.getRequestDispatcher("AdminListServlet").forward(request, response);
			
			}
			else
			{
				request.setAttribute("adminBean", adminBean);
				request.setAttribute("msgadmin", " failed to update ");
				request.getRequestDispatcher("AdminUpdate.jsp").forward(request, response);
				
			}
		}

	
	}

}
