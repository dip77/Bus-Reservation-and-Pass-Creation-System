package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusCategoryBean;
import com.digimation.gujjubus.dao.BusCategoryDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class BusCategoryValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busCategory=request.getParameter("txtBusCatName");
		boolean isError=false;
	if(ValidateUtils.isEmpty(busCategory))
	{
		isError=true;
		request.setAttribute("msgbuscat", "*");
	}
	else if(ValidateUtils.validateText(busCategory))
	{
		isError=true;
		request.setAttribute("msgbuscarname", "please enter valid bus category");
	}
	if(isError)
		request.getRequestDispatcher("BusCategoryUpdate.jsp").forward(request, response);
	else
	{
		String busCategoryId=request.getParameter("id");//if valid data then create id
		BusCategoryBean busCategoryBeanObj=new BusCategoryBean();
		busCategoryBeanObj.setBusCategory(busCategory);
		busCategoryBeanObj.setBusCategoryId(Integer.parseInt(busCategoryId));
		if(new BusCategoryDAO().updateBusCategory(busCategoryBeanObj)){
			request.setAttribute("msgbuscat", " successfully updated");
			request.getRequestDispatcher("BusCategoryListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgcity", "failed to add "+busCategory);//use less
	    	request.getRequestDispatcher("BusCategorysUpdate.jsp").forward(request, response);
		}

		
	}

	}

}
