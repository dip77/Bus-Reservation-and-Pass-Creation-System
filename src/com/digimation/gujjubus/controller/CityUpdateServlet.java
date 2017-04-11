package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.CityBean;
import com.digimation.gujjubus.dao.CityDAO;
public class CityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String id=request.getParameter("id");
		CityBean cityBeanObj =new CityDAO().getCityListByPK(Integer.parseInt(id));
		request.setAttribute("cityBean",cityBeanObj);
		request.getRequestDispatcher("CityUpdate.jsp").forward(request, response);
	}

}
