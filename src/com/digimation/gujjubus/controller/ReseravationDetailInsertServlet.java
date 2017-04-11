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

public class ReseravationDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String []seats=request.getParameter("id").split(",");
HttpSession session=request.getSession();
ReservationBean rb=(ReservationBean)session.getAttribute("reservationBean");
	ReservationDetailBean reservationDetailBeanobj=new ReservationDetailBean();
	reservationDetailBeanobj.setSeatNo(seats);
	reservationDetailBeanobj.setSeatTypeId(1);

	if(new ReservationDetailDAO().addReservationDetail(reservationDetailBeanobj,rb))
	{
		request.setAttribute("msgresdet", "successfully a added");
		request.getRequestDispatcher("ReservationListServlet").forward(request, response);
	}		
	
	else
	{
		request.setAttribute("msgresdet", "failed to add");
		request.getRequestDispatcher("ReservationDetailInsert.jsp").forward(request, response);
	
	}
session.removeAttribute("reservationBean");

	}

}
