package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.ScheduleDetailBean;
import com.digimation.gujjubus.dao.ScheduleDetailDAO;

public class GuestScheduleSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		ScheduleDetailBean scheduleDetailBean=new ScheduleDetailDAO().getScheduleDetailListByPK(Integer.parseInt(id));
		HttpSession session=request.getSession();
		session.setAttribute("scheduleDetailBean", scheduleDetailBean);
		System.out.println("bean set");
		System.out.println(session.getAttribute("userBean")+" bsean");
		if(session.getAttribute("userBean")==null)
		{
			System.out.println("login");
			request.setAttribute("msglogin","please login to continue");
			request.getRequestDispatcher("UserLoginPage.jsp").forward(request, response);
			
		}
		else
		{	
			System.out.println("done");
			response.sendRedirect("UserReservationInsert.jsp");
			
		}
		}

}
