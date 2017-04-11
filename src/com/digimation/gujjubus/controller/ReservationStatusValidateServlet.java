package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ReservationStatusBean;
import com.digimation.gujjubus.dao.ReservationStatusDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class ReservationStatusValidateServlet extends HttpServlet {
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
			request.setAttribute("msgreservationstaus", "*");
		}
		else if(ValidateUtils.validateText(reservationStatus))
		{
			isError=true;
			request.setAttribute("msgreservationstatustype", "please enter valid reservation status type");
		}
		
		if(isError)
			request.getRequestDispatcher("ReservationStatusUpdate.jsp").forward(request, response);
		else
		{
			
			String reservationStatusId=request.getParameter("id");//if valid data then create var
			ReservationStatusBean reservationStatusBeanObj=new ReservationStatusBean();
			reservationStatusBeanObj.setReservationStatus(reservationStatus);
			reservationStatusBeanObj.setReservationStatusId(Integer.parseInt(reservationStatusId));
			if(new ReservationStatusDAO().updateReservationStatus(reservationStatusBeanObj)){
				request.setAttribute("msgsreservationstatus"," successfully updated");
				request.getRequestDispatcher("ReservationStatusListServlet").forward(request, response);
			}
			else{
				request.setAttribute("msgreservationstatus", "failed to update"+reservationStatus);//use less
		    	request.getRequestDispatcher("ReservationStatusUpdate.jsp").forward(request, response);
			}

			
		}
	
	}

}
