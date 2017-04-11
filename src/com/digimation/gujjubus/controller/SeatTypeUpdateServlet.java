package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.SeatTypeBean;
import com.digimation.gujjubus.dao.SeatTypeDAO;

public class SeatTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  seatTypeid=request.getParameter("id");
		 SeatTypeBean passTypeBeanObj = new SeatTypeDAO().getSeatTypeListByPK(Integer.parseInt(seatTypeid));
		request.setAttribute("seatTypeBean",passTypeBeanObj);
		request.getRequestDispatcher("SeatTypeUpdate.jsp").forward(request, response);

	}

}
