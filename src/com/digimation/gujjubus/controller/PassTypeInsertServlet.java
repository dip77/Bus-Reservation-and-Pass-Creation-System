package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.PassTypeBean;
import com.digimation.gujjubus.dao.PassTypeDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class PassTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passType=request.getParameter("txtPassTypeName");
		boolean isError=false;
	if(ValidateUtils.isEmpty(passType))
	{
		isError=true;
		request.setAttribute("msgpasstype", "* Please Enter Pass Type");
	}
	else if(ValidateUtils.validateText(passType))
	{
		isError=true;
		request.setAttribute("msgpasstypes", "please enter valid pass type");
	}
	
	if(isError)
		request.getRequestDispatcher("PassTypeInsert.jsp").forward(request, response);
	else
	{
		PassTypeBean passTypeBeanObj=new PassTypeBean();
		passTypeBeanObj.setPassType(passType);
		if(new PassTypeDAO().addPassType(passTypeBeanObj)){
			request.setAttribute("msgpasstype", passType+" successfully added");
			request.getRequestDispatcher("PassTypeListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgcity", "failed to add "+passType);
	    	request.getRequestDispatcher("PassTypeInsert.jsp").forward(request, response);
		}
		
	}

	}

}
