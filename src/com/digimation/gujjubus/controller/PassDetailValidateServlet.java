package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.dao.PassDetailDAO;

public class PassDetailValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val=request.getParameter("selvalidity");
		String termVal=request.getParameter("seltermvalidity");
		String passDetailId=request.getParameter("id");
		PassDetailBean passDetailBeanObj=new PassDetailBean();
		passDetailBeanObj.setPassDetailId(Integer.parseInt(passDetailId));
		passDetailBeanObj.setTermValidity(Integer.parseInt(termVal));
		passDetailBeanObj.setValidity(Integer.parseInt(val));
		passDetailBeanObj.setTotalAmount(Integer.parseInt(val)*20);
		if(new PassDetailDAO().updatePass(passDetailBeanObj))
		{
			
			request.setAttribute("busdet", "successfully updated");
			request.getRequestDispatcher("PassDetailListServlet").forward(request, response);
		}
		else
		{
			request.setAttribute("busdet", "failed to update");
			request.getRequestDispatcher("PassDetailUpdate.jsp").forward(request, response);
		}
	}

}
