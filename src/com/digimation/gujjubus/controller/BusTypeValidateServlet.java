package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusTypeBean;
import com.digimation.gujjubus.dao.BusTypeDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class BusTypeValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busType=request.getParameter("txtBusTypeName");
		boolean isError=false;
	if(ValidateUtils.isEmpty(busType))
	{
		isError=true;
		request.setAttribute("msgbustype", "*");
	}
	else if(ValidateUtils.validateText(busType))
	{
		isError=true;
		request.setAttribute("msbustype", "please enter valid bus type");
	}
	if(isError)
		request.getRequestDispatcher("BusTypeUpdate.jsp").forward(request, response);
	else
	{
		String busTypeId=request.getParameter("id");//if valid data then create var
		BusTypeBean busTypeBeanObj=new BusTypeBean();
		busTypeBeanObj.setBusType(busType);
		busTypeBeanObj.setBusTypeId(Integer.parseInt(busTypeId));
		if(new BusTypeDAO().updateBusType(busTypeBeanObj)){
			request.setAttribute("msgbuscat"," successfully updated");
			request.getRequestDispatcher("BusTypeListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgcity", "failed to update"+busType);//use less
	    	request.getRequestDispatcher("BusTypeUpdate.jsp").forward(request, response);
		}

		
	}

	}

}
