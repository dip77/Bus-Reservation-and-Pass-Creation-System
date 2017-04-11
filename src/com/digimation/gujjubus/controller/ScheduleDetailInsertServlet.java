package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ScheduleDetailBean;
import com.digimation.gujjubus.dao.BusDetailDAO;
import com.digimation.gujjubus.dao.ScheduleDetailDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class ScheduleDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String routeId=request.getParameter("selroute");
		String sourceId=request.getParameter("Source");
		String destinationId=request.getParameter("Destination");
		String weekOffDay=request.getParameter("weekOffDay");
		String offDate=request.getParameter("weekOffDate");
		String reachTime=request.getParameter("reachTime");
		String departureTime=request.getParameter("departureTime");
		String arrivalTime=request.getParameter("arrivalTime");	
		String busNo=request.getParameter("selbusno");
		String distance=request.getParameter("distance");
		boolean isError=false;
		if(ValidateUtils.isEmpty(distance))
		{
			request.setAttribute("msgdistance", "please enter distance");
			isError=true;
		}
		if(routeId.equals("0"))
		{
			request.setAttribute("msgroute", "please select route");
			isError=true;
		}
		if(busNo.equals("0"))
		{
			request.setAttribute("msgbusno", "please select bus no");
			isError=true;
		}
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
		if(reachTime=="")
		{
			request.setAttribute("msgreach", "please select reach time");
			isError=true;
		}
		if(departureTime=="")
		{
			request.setAttribute("msgdep", "please select departure time");
			isError=true;
		}
		if(arrivalTime=="")
		{
			request.setAttribute("msgarrv", "please select arrival time");
			isError=true;
		}
		if(isError)
		{
			request.getRequestDispatcher("ScheduleDetailInsert.jsp").forward(request, response);
		}
		else
		{
			ScheduleDetailBean scheduleDetailBeanObj=new ScheduleDetailBean();
			scheduleDetailBeanObj.setArrivalTime(arrivalTime);
			scheduleDetailBeanObj.setDepartureTime(departureTime);
			scheduleDetailBeanObj.setDestinationId (new ScheduleDetailDAO().getStationId(destinationId));
			scheduleDetailBeanObj.setSourceId(new ScheduleDetailDAO().getStationId(sourceId));
			scheduleDetailBeanObj.setOffDate(offDate);
			scheduleDetailBeanObj.setWeekOfDay(Integer.parseInt(weekOffDay));
			scheduleDetailBeanObj.setScheduleDetailId(2);
			scheduleDetailBeanObj.setDistance(Integer.parseInt(distance));
		
			scheduleDetailBeanObj.setReachTime(reachTime);
			scheduleDetailBeanObj.setBusDetailId(new BusDetailDAO().getBusDetailId(busNo,
					Integer.parseInt(routeId)));
			if(new ScheduleDetailDAO().addScheduleDetail(scheduleDetailBeanObj))
			{
				request.setAttribute("msgschedule", "sucessfully added");
				request.getRequestDispatcher("ScheduleDetailListServlet").forward(request, response);
			}
			else
			{	
				request.setAttribute("msgschedule", "failed to add");
				request.getRequestDispatcher("ScheduleDetailInsert.jsp").forward(request, response);
			}
			
		}

	}

}
