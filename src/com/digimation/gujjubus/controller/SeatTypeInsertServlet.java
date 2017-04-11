package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.SeatTypeBean;
import com.digimation.gujjubus.dao.SeatTypeDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class SeatTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seatType=request.getParameter("txtSeatTypeName");
		boolean isError=false;
	if(ValidateUtils.isEmpty(seatType))
	{
		isError=true;
		request.setAttribute("msgseattype", "*Enter Seat");
	}
	else if(ValidateUtils.validateText(seatType))
	{
		isError=true;
		request.setAttribute("msgseattype", "please enter valid seat type");
	}
	
	if(isError)
		request.getRequestDispatcher("SeatTypeInsert.jsp").forward(request, response);
	else
	{
		SeatTypeBean seatTypeegoryBeanObj=new SeatTypeBean();
		seatTypeegoryBeanObj.setSeatType(seatType);
		if(new SeatTypeDAO().addSeatType(seatTypeegoryBeanObj)){
			request.setAttribute("msgseattype", seatType+" successfully added");
			request.getRequestDispatcher("SeatTypeListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgcity", "failed to add "+seatType);
	    	request.getRequestDispatcher("SeatTypeInsert.jsp").forward(request, response);
		}
		
	}

	}

}
