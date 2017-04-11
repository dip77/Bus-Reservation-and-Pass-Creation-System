package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.ReservationBean;
import com.digimation.gujjubus.dao.ReservationDAO;

public class ReservationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reservationId=request.getParameter("id");
		ReservationBean reservationBeanObj =new ReservationDAO().getReservationListByPK(Integer.parseInt(reservationId));
		request.setAttribute("reservationBean",reservationBeanObj);
		HttpSession session=request.getSession();
		session.setAttribute("busNo",reservationBeanObj.getBusNo());
		request.getRequestDispatcher("ReservationUpdate.jsp").forward(request, response);

	}

}
