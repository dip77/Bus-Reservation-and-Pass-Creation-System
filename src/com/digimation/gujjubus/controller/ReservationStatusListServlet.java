package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ReservationStatusBean;
import com.digimation.gujjubus.dao.ReservationStatusDAO;
public class ReservationStatusListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ReservationStatusBean> listOfReservationStatusBeans =new ReservationStatusDAO().getReservationStatusList();
		request.setAttribute("listofreservationstatus", listOfReservationStatusBeans);
		request.getRequestDispatcher("ReservationStatusList.jsp").forward(request, response);

	}

}
	