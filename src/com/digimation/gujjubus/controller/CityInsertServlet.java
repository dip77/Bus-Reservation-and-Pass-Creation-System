package com.digimation.gujjubus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.CityBean;
import com.digimation.gujjubus.dao.CityDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class CityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityName=request.getParameter("txtCityName");
	boolean isError=false;
	if(ValidateUtils.isEmpty(cityName))
	{
		isError=true;
		request.setAttribute("msgcityname", "* City Name");
	}
	else if(ValidateUtils.validateText(cityName))
	{
		isError=true;
		request.setAttribute("mscityname", "please enter valid city name");
	}
	
	if(isError)
		request.getRequestDispatcher("CityInsert.jsp").forward(request, response);
	else
	{
		CityBean cityBeanObj=new CityBean();
		cityBeanObj.setCityName(cityName);
		if(new CityDAO().addCity(cityBeanObj)){
			request.setAttribute("msgcity", cityName+" successfully added");
			request.getRequestDispatcher("CityListServlet").forward(request, response);
		}
			//in else duplicatation error may come
		else{
			request.setAttribute("msgcity", "failed to add "+cityName);
	    	request.getRequestDispatcher("CityInsert.jsp").forward(request, response);
		}
		}
	}
	

}
