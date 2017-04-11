package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.ReservationBean;
import com.digimation.gujjubus.bean.ReservationDetailBean;
import com.digimation.gujjubus.dao.ReservationDetailDAO;
public class UserReservationConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ReservationBean rb=(ReservationBean)session.getAttribute("reservationBean");
		ReservationDetailBean reservationDetailBean=(ReservationDetailBean)session.getAttribute("reservationDetailBean");
		session.removeAttribute("reservationBean");
		session.removeAttribute("reservationDetailBean");
		request.setAttribute("reservationBean", rb);
		request.setAttribute("reservationDetailBean",reservationDetailBean);
		if(new ReservationDetailDAO().addReservationDetail(reservationDetailBean,rb))
		{
			request.setAttribute("msgreservation", "successfully booked");
			request.getRequestDispatcher("UserReservationPrint.jsp").forward(request, response);
	
		}
	}
}
