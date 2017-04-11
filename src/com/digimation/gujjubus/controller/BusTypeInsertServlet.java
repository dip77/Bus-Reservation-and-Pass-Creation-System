package com.digimation.gujjubus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusTypeBean;
import com.digimation.gujjubus.dao.BusTypeDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class BusTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busType=request.getParameter("txtBusTypeName");
		boolean isError=false;
	if(ValidateUtils.isEmpty(busType))
	{
		isError=true;
		request.setAttribute("msgbustype", "Enter Bus Type");
	}
	else if(ValidateUtils.validateText(busType))
	{
		isError=true;
		request.setAttribute("msbustype", "please enter valid bu type");
	}
	if(isError)
		request.getRequestDispatcher("BusTypeInsert.jsp").forward(request, response);
	else
	{
		BusTypeBean busTypeegoryBeanObj=new BusTypeBean();
		busTypeegoryBeanObj.setBusType(busType);
		if(new BusTypeDAO().addBusType(busTypeegoryBeanObj)){
			request.setAttribute("msgbustype", busType+" successfully added");
			request.getRequestDispatcher("BusTypeListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgcity", "failed to add "+busType);
	    	request.getRequestDispatcher("BusTypeInsert.jsp").forward(request, response);
		}
		
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
	
	}


}
