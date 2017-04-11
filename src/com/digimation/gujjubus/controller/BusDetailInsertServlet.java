package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusDetailBean;
import com.digimation.gujjubus.dao.BusDetailDAO;
public class BusDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sourceId=request.getParameter("selsource");
		String busNo=request.getParameter("selbusNo");
		boolean isError=false;
		if(sourceId.equals("0"))
		{
			request.setAttribute("msgsource", "please select source");
			isError=true;
		}
		if(busNo.equals("0"))
		{
			request.setAttribute("msgbusno", "please select busno");
			isError=true;
		}
		if(isError)
		{
			request.getRequestDispatcher("BusDetailInsert.jsp").forward(request, response);
		}
		else
		{
			BusDetailBean busDetailBean=new BusDetailBean();
			busDetailBean.setBusNo(busNo);
			busDetailBean.setRouteid(Integer.parseInt(sourceId));
			if(new BusDetailDAO().addBusDetail(busDetailBean))
			{
				request.setAttribute("msgbusDetail", "busDetail successfully added");
				request.getRequestDispatcher("BusDetailListServlet").forward(request, response);
			}
			
			else
			{
				request.setAttribute("msgbusDetail"," failed to add busDetail");
				request.getRequestDispatcher("BusDetailInsert.jsp").forward(request, response);
			}
		}
			

	
	}

}
