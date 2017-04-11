
package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusBean;
import com.digimation.gujjubus.dao.BusDAO;
import com.digimation.gujjubus.util.ValidateUtils;
public class BusValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String busNo=request.getParameter("txtbusNo");
		String capacity=request.getParameter("numcapacity");
		String isAvailable=request.getParameter("rdoAvalibility");
		String busDepoId=request.getParameter("selbusDepo");
		String busCategoryId=request.getParameter("rdobusCategory");
		String busTypeId=request.getParameter("rdobusType");
		boolean isError=false;
		BusBean busBean=new BusBean();	
	if(ValidateUtils.isEmpty(capacity))
		{
			isError=true;
			request.setAttribute("msgbuscapacity", "please enter capacity");
		
		}
	/*else if(ValidateUtils.validateNumber(capacity))
	{
		isError=true;
		request.setAttribute("msgbuscapacity", "please enter valid capacity");
	}
*/
	else
		busBean.setCapacity(Integer.parseInt(capacity));
		busBean.setBusDepoId(Integer.parseInt(busDepoId));
			busBean.setBusTypeId(Integer.parseInt(busTypeId));
			busBean.setBusCategoryId(Integer.parseInt(busCategoryId));
			busBean.setIsAvailable(isAvailable);
			busBean.setBusNo(busNo);

		if(isError)

		{
			request.setAttribute("busBean", busBean);
			request.getRequestDispatcher("BusUpdate.jsp").forward(request, response);
		}
		else
		{
			
			if(new BusDAO().updateBus(busBean))
			{
				request.setAttribute("msgbus", "successfully updated");
				request.getRequestDispatcher("BusListServlet").forward(request, response);
			}
			
			else
			{
				request.setAttribute("msgbus", "failed  to update");
				request.getRequestDispatcher("BusUpdate.jsp").forward(request, response);
			}
		}

	}

}
