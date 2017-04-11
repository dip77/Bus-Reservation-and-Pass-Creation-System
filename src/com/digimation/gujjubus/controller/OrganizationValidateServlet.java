package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.OrganizationBean;
import com.digimation.gujjubus.dao.OrganizationDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class OrganizationValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String organizationName=request.getParameter("txtOrgName");
		String organizationAddress=request.getParameter("txtOrgAddress");
		String organizationId=request.getParameter("id");
		OrganizationBean orgBean=new OrganizationBean();
		boolean isError=false;
	if(ValidateUtils.isEmpty(organizationName))
	{
		isError=true;
		request.setAttribute("msgorgname", "*");
	}
	else if(ValidateUtils.validateText(organizationName))
	{
		isError=true;
		request.setAttribute("msorgname", "please enter valid org name");
	}
	else if(ValidateUtils.validateText(organizationAddress))
	{
		isError=true;
		request.setAttribute("msgorgadd", "please enter valid org address");
	}
	
	else
		orgBean.setOrganizationName(organizationName);
	if(ValidateUtils.isEmpty(organizationAddress))
	{
		isError=true;
		request.setAttribute("msgorgadd", "*");
	}	
	else
		orgBean.setOrganizationAddress(organizationAddress);
	if(isError)
	{
	request.setAttribute("orgBean", orgBean);
		request.getRequestDispatcher("OrganizationUpdate.jsp").forward(request, response);
	
	}
		else
	{
		
		orgBean.setOrganizationId(Integer.parseInt(organizationId));
		if(new OrganizationDAO().updateOrganization(orgBean)){
			request.setAttribute("msgcity"," successfully updated");
			request.getRequestDispatcher("OrganizationListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgcity", "failed to update ");//use less
	    	request.getRequestDispatcher("organizationupdate.jsp").forward(request, response);
		}

	}
	}

}
