package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.PassTypeBean;
import com.digimation.gujjubus.dao.PassTypeDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class PassTypeValidateServlet extends HttpServlet {
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
		request.setAttribute("msgpasstype", "*");
	}
	else if(ValidateUtils.validateText(passType))
	{
		isError=true;
		request.setAttribute("msgpasstype", "please enter valid pass type");
	}
	
	if(isError)
		request.getRequestDispatcher("PassTypeUpdate.jsp").forward(request, response);
	else
	{
		String passTypeId=request.getParameter("id");//if valid data then create var
		PassTypeBean passTypeBeanObj=new PassTypeBean();
		passTypeBeanObj.setPassType(passType);
		passTypeBeanObj.setPassTypeId(Integer.parseInt(passTypeId));
		if(new PassTypeDAO().updatePassType(passTypeBeanObj)){
			request.setAttribute("msgpasscat"," successfully updated");
			request.getRequestDispatcher("PassTypeListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgcity", "failed to update"+passType);//use less
	    	request.getRequestDispatcher("PassTypeUpdate.jsp").forward(request, response);
		}


	}

}
}