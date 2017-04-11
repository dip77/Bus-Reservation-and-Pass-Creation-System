package com.digimation.gujjubus.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.dao.PassDetailDAO;

public class UserPassPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PassDetailBean passBean = new PassDetailDAO()
				.getPassDetailListByPK(Integer.parseInt(id));

		PassDetailBean passDetailBean = new PassDetailDAO().getUniquePassDetail(passBean.getStartDate(),passBean.getEndDate());
				request.setAttribute("passDetailBean", passDetailBean);

		/*
		 * passBean.getFirstName(); passBean.getLastName();
		 * passBean.getMiddleName(); passBean.getStartDate();
		 * passBean.getDestination(); passBean.getSource();
		 * passBean.getOrganizationName(); passBean.getOrganizationName();
		 * passBean.getPhoto(); passBean.getTotalAmount();
		 */
		request.getRequestDispatcher("PassPrint.jsp")
				.forward(request, response);
	}
}
