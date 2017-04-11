package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusCategoryBean;
import com.digimation.gujjubus.dao.BusCategoryDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class BusCategoryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busCategory=request.getParameter("txtBusCategoryName");
		boolean isError=false;
	if(ValidateUtils.isEmpty(busCategory))
	{
		isError=true;
		request.setAttribute("msgbuscategory", "*Enter Bus Category");
	}else if(ValidateUtils.validateText(busCategory))
	{
		isError=true;
		request.setAttribute("msgbuscategory", "please enter valid bus category");
	}
	if(isError)
		request.getRequestDispatcher("BusCategoryInsert.jsp").forward(request, response);
	else
	{
		BusCategoryBean busCategoryBeanObj=new BusCategoryBean();
		busCategoryBeanObj.setBusCategory(busCategory);
		if(new BusCategoryDAO().addBusCategory(busCategoryBeanObj)){
			request.setAttribute("msgbuscat", busCategory+" successfully added");
			request.getRequestDispatcher("BusCategoryListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgcity", "failed to add "+busCategory);
	    	request.getRequestDispatcher("BusCategoryInsert.jsp").forward(request, response);
		}

		
	}

	}

}
