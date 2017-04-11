package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.StationBean;
import com.digimation.gujjubus.dao.StationDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class StationValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityId=request.getParameter("selstationCity");
		String stationName=request.getParameter("txtstationName");
		String stationId=request.getParameter("id");
		StationBean stationBean=new StationBean();
		boolean isError=false;
		if(ValidateUtils.isEmpty(stationName))
		{
			isError=true;
			request.setAttribute("msgstationname", "*");
		}
		else if(ValidateUtils.validateText(stationName))
		{
			isError=true;
			request.setAttribute("msgstationname", "please enter valid station name");
		}

		else
			stationBean.setStationName(stationName);
				if(isError)
				{
					request.setAttribute("stationBean", stationBean);
					request.getRequestDispatcher("StationInsert.jsp").forward(request, response);
				}
				else
				{					
					stationBean.setStationId(Integer.parseInt(stationId));
					stationBean.setCityId(Integer.parseInt(cityId));
					if(new StationDAO().updateStation(stationBean))
					{
		
						request.setAttribute("msgstation", "successfully updated");
						request.getRequestDispatcher("StationListServlet").forward(request, response);
					}
					else
					{
						request.setAttribute("msgstation", " failed to updates");
						request.getRequestDispatcher("StationInsert.jsp").forward(request, response);
					}
				}


	}

}
