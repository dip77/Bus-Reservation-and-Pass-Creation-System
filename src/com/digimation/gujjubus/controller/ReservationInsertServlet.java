package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.ReservationBean;
import com.digimation.gujjubus.bean.ScheduleDetailBean;
import com.digimation.gujjubus.dao.ReservationDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class ReservationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String noOfSeat=request.getParameter("noOfSeat");
String journeyDate=request.getParameter("resDate");
String userId=request.getParameter("seluser");
boolean isError=false;
if(userId.equals("0"))
{
	isError=true;
	request.setAttribute("msguser","please select user");
}
if(journeyDate.equals(""))
{
	isError=true;
	request.setAttribute("msgdate", "please select journey date");
	
}

if(ValidateUtils.isEmpty(noOfSeat))
{
	isError=true;
	request.setAttribute("msgseat", "please enter no of seat");
	
}
if(isError)
{
	request.getRequestDispatcher("ReservationInsert.jsp").forward(request, response);
}
else
{
	HttpSession session=request.getSession();
	ScheduleDetailBean scheduleDetailBean= (ScheduleDetailBean)session.getAttribute("scheduleDetailBean");
	ReservationBean reservationBeanObj=new  ReservationBean();
	reservationBeanObj.setJourneyDate(journeyDate);
	reservationBeanObj.setBusNo(scheduleDetailBean.getBusNo());
	reservationBeanObj.setDestinationId(scheduleDetailBean.getSourceId());
	reservationBeanObj.setSourceId(scheduleDetailBean.getDestinationId());
reservationBeanObj.setDistance(scheduleDetailBean.getDistance());
reservationBeanObj.setNoOfSeat(Integer.parseInt(noOfSeat));
reservationBeanObj.setTotalAmount((int) ((int)reservationBeanObj.getNoOfSeat()*(scheduleDetailBean.getDistance()*0.8)));
reservationBeanObj.setUserId(Integer.parseInt(userId));
 session=request.getSession();
session.setAttribute("reservationBean",reservationBeanObj);
request.getRequestDispatcher("ReservationDetailInsert.jsp").forward(request, response);

}
	}

}
