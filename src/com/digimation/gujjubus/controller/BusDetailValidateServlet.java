package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusDetailBean;
import com.digimation.gujjubus.dao.BusDetailDAO;
public class BusDetailValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busDetailId=request.getParameter("id");
		String sourceId=request.getParameter("selsource");
		String destinationId=request.getParameter("seldestination");
		String busNo=request.getParameter("selbusNo");
		String isAvailable=request.getParameter("rdoavailable");
		BusDetailBean busDetailBean=new BusDetailBean();
		busDetailBean.setBusDetailid(Integer.parseInt(busDetailId));
		busDetailBean.setBusNo(busNo);
		busDetailBean.setRouteid(new BusDetailDAO().getRouteId(Integer.parseInt(sourceId),Integer.parseInt(destinationId)));
	busDetailBean.setIsAvailable(isAvailable);
	if(new BusDetailDAO().updateBusDetail(busDetailBean))
	{
			request.setAttribute("msgbusdetail", busDetailId+"sucessfully updated");
			request.getRequestDispatcher("BusDetailListServlet").forward(request, response);
	}
	else
	{
		request.setAttribute("msgbusdetail", "failed  to update");
		request.getRequestDispatcher("BusDetailUpdate.jsp").forward(request, response);
	}
	}

}
