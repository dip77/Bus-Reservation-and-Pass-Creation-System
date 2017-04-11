package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.ReservationDAO;
import com.digimation.gujjubus.dao.ReservationDetailDAO;

public class ReservationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reservationid=request.getParameter("id");	
		if(new ReservationDetailDAO().removeReservationDetail(Integer.parseInt(reservationid)))
			request.setAttribute("msgreservation", " successfully delete");
		
		else
			request.setAttribute("msgreservation", " failed to delete");
		request.getRequestDispatcher("ReservationListServlet").forward(request, response);
	
	}

}
