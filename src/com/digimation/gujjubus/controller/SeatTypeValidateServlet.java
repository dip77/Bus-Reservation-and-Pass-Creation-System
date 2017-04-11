package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.SeatTypeBean;
import com.digimation.gujjubus.dao.SeatTypeDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class SeatTypeValidateServlet extends HttpServlet {
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
		request.setAttribute("msgseattype", "*");
	}else if(ValidateUtils.validateText(seatType))
	{
		isError=true;
		request.setAttribute("msgseattype", "please enter valid seat type");
	}
	if(isError)
		request.getRequestDispatcher("SeatTypeUpdate.jsp").forward(request, response);
	else
	{
		
		String seatTypeId=request.getParameter("id");//if valid data then create var
		SeatTypeBean seatTypeBeanObj=new SeatTypeBean();
		seatTypeBeanObj.setSeatType(seatType);
		seatTypeBeanObj.setSeatTypeId(Integer.parseInt(seatTypeId));
		if(new SeatTypeDAO().updateSeatType(seatTypeBeanObj)){
			request.setAttribute("msgseattype"," successfully updated");
			request.getRequestDispatcher("SeatTypeListServlet").forward(request, response);
		}
		else{
			request.setAttribute("msgseattype", "failed to update"+seatType);//use less
	    	request.getRequestDispatcher("SeatTypeUpdate.jsp").forward(request, response);
		}

		
	}

	}

}
