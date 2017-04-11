package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.OrganizationBean;
import com.digimation.gujjubus.bean.PassBean;
import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.OrganizationDAO;
import com.digimation.gujjubus.dao.PassDAO;
import com.digimation.gujjubus.dao.PassDetailDAO;
public class PassRenewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sourceId,destinationId, passTypeId,start,
	 validity,termValidity,organizationName,organizationAddress,
	 userId,orgId,fileName;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserBean userBean=(UserBean)session.getAttribute("userBean");
		System.out.println("user id"+userBean.getUserId());
		int passId= new PassDAO().getPassID(userBean.getUserId());
		PassDetailBean passDetailBean= new PassDetailBean();
		boolean isError=false;
		System.out.println("pass id"+passId);
		start=request.getParameter("rdostart");
		validity=request.getParameter("rdoval");
		if(start==null)
		{
			isError=true;
			request.setAttribute("msgday", "select day of pass");
		}
		if(validity==null)
		{
			isError=true;
			request.setAttribute("msgval", "select validity");
		}
	if(isError)
	{
		request.getRequestDispatcher("RenewPass.jsp").forward(request, response);
	}
	else
	{
		if(start.equals("1"))
			passDetailBean.setStartDate("curdate()");
		else 
			passDetailBean.setStartDate("date_add(curdate(),interval 1 day)");
			passDetailBean.setPassId(passId);
			passDetailBean.setValidity(Integer.parseInt(validity));
			passDetailBean.setTotalAmount(Integer.parseInt(validity)*200);
			PassBean passBean=new PassDAO().getPassListByPK(passId);
			OrganizationBean organizationBean=new OrganizationDAO().getOrganizationListByPK(passBean.getOrgId());
			session.setAttribute("passDetailBean", passDetailBean);
			session.setAttribute("PassBean", passBean);
			session.setAttribute("orgBean", organizationBean);
			response.sendRedirect("PassRenewConfirm.jsp");
	}
	
	}	

}
