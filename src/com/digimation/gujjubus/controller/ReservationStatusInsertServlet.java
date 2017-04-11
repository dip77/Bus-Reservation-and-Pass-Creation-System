package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ReservationStatusBean;
import com.digimation.gujjubus.dao.ReservationStatusDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class ReservationStatusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reservationStatus=request.getParameter("txtReservationStatusName");
		boolean isError=false;
	if(ValidateUtils.isEmpty(reservationStatus))
	{
		isError=true;
		request.setAttribute("msgreservationstatustype", "*");
	}
	else if(ValidateUtils.validateText(reservationStatus))
	{
		isError=true;
		request.setAttribute("msgreservationstatustype", "please enter valid reservation status type");
	}
	
	if(isError)
		request.getRequestDispatcher("ReservationStatusInsert.jsp").forward(request, response);
	else
	{
		ReservationStatusBean reservationStatusBeanObj=new ReservationStatusBean();
		reservationStatusBeanObj.setReservationStatus(reservationStatus);
		if(new ReservationStatusDAO().addReservationStatus(reservationStatusBeanObj)){
			request.setAttribute("msgreservationstatustype", reservationStatus+" successfully added");
			request.getRequestDispatcher("ReservationStatusListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgreservationstatus", "failed to add "+reservationStatus);
	    	request.getRequestDispatcher("ReservationStatusInsert.jsp").forward(request, response);
		}
		
	}


	}

}
