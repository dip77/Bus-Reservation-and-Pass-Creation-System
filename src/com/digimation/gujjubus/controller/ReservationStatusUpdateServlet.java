package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ReservationStatusBean;
import com.digimation.gujjubus.dao.ReservationStatusDAO;
public class ReservationStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  reservationStatusid=request.getParameter("id");
		 ReservationStatusBean reservationStatusBeanObj = new ReservationStatusDAO().getReservationStatusListByPK(Integer.parseInt(reservationStatusid));
		request.setAttribute("reservationStatusBean",reservationStatusBeanObj);
		request.getRequestDispatcher("ReservationStatusUpdate.jsp").forward(request, response);

	}

}
