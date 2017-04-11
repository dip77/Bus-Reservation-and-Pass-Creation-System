package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ReservationBean;
import com.digimation.gujjubus.dao.ReservationDAO;
public class ReservationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ReservationBean> listOfReservationBeans=new ReservationDAO().getReservationList();
		request.setAttribute("listofreservation", listOfReservationBeans);
		request.getRequestDispatcher("ReservationList.jsp").forward(request, response);

		
	}

}
