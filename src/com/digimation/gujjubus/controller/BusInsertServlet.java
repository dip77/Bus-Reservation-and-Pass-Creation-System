package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusBean;
import com.digimation.gujjubus.dao.BusDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class BusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String busNo=request.getParameter("txtbusNo");
String capacity=request.getParameter("numcapacity");
String busDepoId=request.getParameter("selbusDepo");
String busCategoryId=request.getParameter("rdobusCategory");
String busTypeId=request.getParameter("rdobusType");
boolean isError=false;
if(ValidateUtils.isEmpty(busNo))
{ 
	isError=true;
	request.setAttribute("msgbusno", "please enter bus no");
}
else if(ValidateUtils.validateBusNo(busNo))
{
	isError=true;
	request.setAttribute("msgbusno", "please enter valid bus no");

}
if(ValidateUtils.isEmpty(capacity))
{
	isError=true;		
	request.setAttribute("msgbuscapacity", "please enter capacity");
}

//else if(ValidateUtils.validateNumber(capacity))
//{
//	isError=true;
//	request.setAttribute("msgbuscapacity", "please enter valid capacity");
//}
if(busDepoId.equals("0"))
{
	isError=true;
	request.setAttribute("msgbusdepo", "please select bus depo");
}
if(busTypeId==null)
{
	isError=true;
	request.setAttribute("msgbustype", "please select bus type");
}
if(busCategoryId==null)
{
	isError=true;
	request.setAttribute("msgbuscat", "please select bus Category");
}
if(isError)
{
	request.getRequestDispatcher("BusInsert.jsp").forward(request, response);
}
else
{
	BusBean busBeanObj=new BusBean();
	busBeanObj.setBusCategoryId(Integer.parseInt(busCategoryId));
	busBeanObj.setBusDepoId(Integer.parseInt(busDepoId));
	busBeanObj.setBusNo(busNo);
	busBeanObj.setBusTypeId(Integer.parseInt(busTypeId));
	busBeanObj.setCapacity(Integer.parseInt(capacity));
	if(new BusDAO().addBus(busBeanObj))
	{
		request.setAttribute("msgbus", busNo+"successfully addedd");
		request.getRequestDispatcher("BusListServlet").forward(request, response);
	}
	
	else
	{
		request.setAttribute("msgbus", busNo+" not addedd");
		request.getRequestDispatcher("BusInsert.jsp").forward(request, response);
	}
}
	}

}
