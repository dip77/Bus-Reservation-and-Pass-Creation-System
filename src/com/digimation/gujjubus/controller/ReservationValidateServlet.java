package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.ReservationBean;
import com.digimation.gujjubus.dao.ReservationDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class ReservationValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noOfSeat=request.getParameter("noOfSeat");
		String reservationId=request.getParameter("id");
		String isCancel=request.getParameter("rdocancel");
		String journeyDate=request.getParameter("resDate");
		String userId=request.getParameter("seluser");
		boolean isError=false;
		if(isCancel.equals("y"))
		{
			new ReservationDAO().cancelReservation(Integer.parseInt(reservationId));
			request.setAttribute("msgres", "successfully cancelled");
			request.getRequestDispatcher("ReservationListServlet").forward(request, response);
		}
		ReservationBean reservationBeanObj=new ReservationBean();
		if(ValidateUtils.isEmpty(noOfSeat))
		{
			isError=true;
			request.setAttribute("msgseat", "please enter no of seat");
			
		}
		else
			reservationBeanObj.setNoOfSeat(Integer.parseInt(noOfSeat));	
		reservationBeanObj.setReservationId(Integer.parseInt(reservationId));
		reservationBeanObj.setIsCancel(isCancel);
		reservationBeanObj.setUserId(Integer.parseInt(userId));
		reservationBeanObj.setJourneyDate(journeyDate.replaceAll("-","/"));
		HttpSession session=request.getSession();
		reservationBeanObj.setBusNo((String)session.getAttribute("busNo"));
		session.invalidate();
		if(isError)
		{
			request.setAttribute("reservationBean", reservationBeanObj);
			request.getRequestDispatcher("ReservationUpdate.jsp").forward(request, response);
			
		}
		else
		{
			session=request.getSession();
			session.setAttribute("resBean",reservationBeanObj);
			response.sendRedirect("ReservationDetailUpdate.jsp");
		}

	}

}
