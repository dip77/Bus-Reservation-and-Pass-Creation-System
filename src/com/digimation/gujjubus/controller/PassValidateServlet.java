package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.PassBean;
import com.digimation.gujjubus.dao.PassDAO;
public class PassValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sourceId=request.getParameter("selsource");
		String destinationId=request.getParameter("seldestination");
		String passTypeId=request.getParameter("rdopassType");
		String passId=request.getParameter("id");
		String isActive=request.getParameter("rdoactive");
		PassBean passBean=new PassBean();
		passBean.setSourceId(Integer.parseInt(sourceId));
		passBean.setDestinationId(Integer.parseInt(destinationId));
		passBean.setPassTypeId(Integer.parseInt(passTypeId));
		passBean.setPassId(Integer.parseInt(passId));
		passBean.setIsActive(isActive);
		if(new PassDAO().updatePass(passBean))	
		{
			request.setAttribute("msgpass", "pass successfully updated");
			request.getRequestDispatcher("PassListServlet").forward(request, response);
		
		}
		else
		{
			request.setAttribute("msgpass", "failed to updated");
			request.getRequestDispatcher("PassUpdate.jsp").forward(request, response);
			
		}
	}

}
