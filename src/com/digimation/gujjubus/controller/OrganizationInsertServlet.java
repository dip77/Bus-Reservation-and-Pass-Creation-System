package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.OrganizationBean;
import com.digimation.gujjubus.dao.OrganizationDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class OrganizationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String organizationName=request.getParameter("txtOrgName");
		String organizationAddress=request.getParameter("txtOrgAddress");
	boolean isError=false;
	if(ValidateUtils.isEmpty(organizationName))
	{
		isError=true;
		request.setAttribute("msgorgname", "*please enter org Name");
	}
	else if(ValidateUtils.validateText(organizationName))
	{
		isError=true;
		request.setAttribute("msorgname", "please enter valid org name");
	}
	
	if(ValidateUtils.isEmpty(organizationAddress))
	{
		isError=true;
		request.setAttribute("msgorgadd", "*please enter  org address");
	}	
	else if(ValidateUtils.validateText(organizationAddress))
	{
		isError=true;
		request.setAttribute("msgorgadd", "please enter valid org address");
	}
	
	if(isError)
		request.getRequestDispatcher("OrganizatioInsert.jsp").forward(request, response);
	else
	{
		OrganizationBean orgBeanObj=new OrganizationBean();
		orgBeanObj.setOrganizationName(organizationName);
		orgBeanObj.setOrganizationAddress(organizationAddress);
		if(new OrganizationDAO().addOrganization(orgBeanObj)){
			request.setAttribute("msgcity", organizationName+" successfully added");
			request.getRequestDispatcher("OrganizationListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgcity", "failed to add "+organizationName);
	    	request.getRequestDispatcher("OrganizatioInsert.jsp").forward(request, response);
		}

		
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
	}

}
