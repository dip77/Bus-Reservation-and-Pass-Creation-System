package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ScheduleBean;
import com.digimation.gujjubus.dao.ScheduleDAO;

public class ScheduleValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String busNo=request.getParameter("selbusNo");
String scheduleId=request.getParameter("id");
ScheduleBean scheduleBean=new ScheduleBean();
scheduleBean.setBusNo(busNo);
scheduleBean.setScheduleId(Integer.parseInt(scheduleId));
if(new ScheduleDAO().updateSchedule(scheduleBean))
{
	request.setAttribute("msgschedule","successfull updated");
	request.getRequestDispatcher("ScheduleListServlet").forward(request, response);
}
else
{

	request.setAttribute("msgschedule","failed to update");
	request.getRequestDispatcher("ScheduleUpdate.jsp").forward(request, response);
	
}
	}

}
