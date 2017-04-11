package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.StationBean;
import com.digimation.gujjubus.dao.StationDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class StationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String cityName=request.getParameter("selstationCity");
String stationName=request.getParameter("txtstationName");
boolean isError=false;

if(ValidateUtils.isEmpty(stationName))
{
	
	isError=true;
	request.setAttribute("msgstationname", "*");
}
//else if(ValidateUtils.validateText(stationName))
//{
//	isError=true;
//	request.setAttribute("msgstationname", "please enter valid station");
//}
if(Integer.parseInt(cityName)==0)
{
	isError=true;
	request.setAttribute("msgcityname", "please enter city name");
}
		if(isError)
		{
			request.getRequestDispatcher("StationInsert.jsp").forward(request, response);
		}
		else
		{
			StationBean stationBean=new StationBean();
			
			stationBean.setCityName(cityName);
			stationBean.setStationName(stationName);
			if(new StationDAO().addStation(stationBean))
			{
				request.setAttribute("msgstation", stationName+"successfully addedd");
				request.getRequestDispatcher("StationListServlet").forward(request, response);
			}
			
			else
			{
				request.setAttribute("msgstation", stationName+" not addedd");
				request.getRequestDispatcher("StationInsert.jsp").forward(request, response);
			}
		}

	}

}
