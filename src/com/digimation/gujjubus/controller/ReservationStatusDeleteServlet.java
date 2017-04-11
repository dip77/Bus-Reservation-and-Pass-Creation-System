package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.ReservationStatusDAO;
public class ReservationStatusDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reservationStatusid=request.getParameter("id");	
		if(new ReservationStatusDAO().removeReservationStatus(Integer.parseInt(reservationStatusid)))
			request.setAttribute("msgreservationstatus", " successfully delete");
		else
			request.setAttribute("msgreservationstatus", " failed to delete");
		request.getRequestDispatcher("ReservationStatusListServlet").forward(request, response);

	}

}
