package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ScheduleDetailBean;
import com.digimation.gujjubus.dao.ScheduleDetailDAO;

public class ScheduleDetailValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sourceId=request.getParameter("Source");
		String destinationId=request.getParameter("Destination");
		String weekOffDay=request.getParameter("weekOffDay");
		String offDate=request.getParameter("weekOffDate");
		String reachTime=request.getParameter("reachTime");
		String departureTime=request.getParameter("departureTime");
		String arrivalTime=request.getParameter("arrivalTime");	
		String scheduleId=request.getParameter("id");
		String busNo=request.getParameter("selbusno");
			boolean isError=false;
		if(sourceId=="")
		{	
			request.setAttribute("msgsource", "please enter source");
			isError=true;		
				
		}
		if(destinationId=="")
		{
			request.setAttribute("msgdest", "please enter destination");
			isError=true;

		}
		ScheduleDetailBean scheduleDetailBeanObj=new ScheduleDetailBean();
		scheduleDetailBeanObj.setArrivalTime(arrivalTime);
		scheduleDetailBeanObj.setDepartureTime(departureTime);
		scheduleDetailBeanObj.setDestinationId (new ScheduleDetailDAO().getStationId(destinationId));
		scheduleDetailBeanObj.setSourceId(new ScheduleDetailDAO().getStationId(sourceId));
		scheduleDetailBeanObj.setOffDate(offDate);	
		scheduleDetailBeanObj.setWeekOfDay(Integer.parseInt(weekOffDay));
		scheduleDetailBeanObj.setBusNo(busNo);
		scheduleDetailBeanObj.setDistance(20);
		scheduleDetailBeanObj.setReachTime(reachTime);
		scheduleDetailBeanObj.setScheduleId(Integer.parseInt(scheduleId));
		if(isError)
		{
			request.setAttribute("scheduleDetailBean",scheduleDetailBeanObj);
			request.getRequestDispatcher("ScheduleDetailUpdate.jsp").forward(request, response);
		}
		else
		{
			if(new ScheduleDetailDAO().updateScheduleDetail(scheduleDetailBeanObj))
			{
				request.setAttribute("msgschedule", "sucessfully updated");
				request.getRequestDispatcher("ScheduleDetailListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("scheduleDetailBean",scheduleDetailBeanObj);
				request.setAttribute("msgschedule", "failed to update");
				request.getRequestDispatcher("ScheduleDetailUpdate.jsp").forward(request, response);
			}


		}

	}

}
