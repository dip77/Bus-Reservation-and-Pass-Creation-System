package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.ReservationDetailBean;
import com.digimation.gujjubus.dao.ReservationDAO;
import com.digimation.gujjubus.dao.ReservationDetailDAO;

public class ReservationDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resId=request.getParameter("id");
	ArrayList<ReservationDetailBean> listOfReservationDetailBeans=
			new ReservationDetailDAO().getReservationDetailListByPK(Integer.parseInt(resId));
		request.setAttribute("resBean", new ReservationDAO().getReservationListByPK(Integer.parseInt(resId)));
		request.setAttribute("listofresdet", listOfReservationDetailBeans);
		request.getRequestDispatcher("ReservationDetailList.jsp").forward(request, response);

	}

}
