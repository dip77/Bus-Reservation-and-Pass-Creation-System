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

public class UserReseravationDetailInsertServlet extends HttpServlet {
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
			if(seats.length!=rb.getNoOfSeat())
			{
				request.setAttribute("msgresdet", "please select only "+rb.getNoOfSeat()+" only");
				request.getRequestDispatcher("UserReservationDetailInsert.jsp").forward(request, response);
			}
			else
			{
		    	session.setAttribute("reservationDetailBean", reservationDetailBeanobj);
				request.setAttribute("msgresdet", "successfully a added");
				request.getRequestDispatcher("UserReservationList.jsp").forward(request, response);
			}
	}

}
