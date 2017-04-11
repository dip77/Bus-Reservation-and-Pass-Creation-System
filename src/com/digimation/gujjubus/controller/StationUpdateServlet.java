package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.StationBean;
import com.digimation.gujjubus.dao.StationDAO;
public class StationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stationId=request.getParameter("id");
		StationBean stationBeanObj =new StationDAO().getStationListByPK(Integer.parseInt(stationId));
		request.setAttribute("stationBean",stationBeanObj);
		request.getRequestDispatcher("StationUpdate.jsp").forward(request, response);

	}

}
