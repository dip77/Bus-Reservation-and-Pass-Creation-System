package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.BusCategoryBean;
import com.digimation.gujjubus.bean.FeedbackBean;
import com.digimation.gujjubus.dao.BusCategoryDAO;
import com.digimation.gujjubus.dao.FeedbackDAO;

public class FeedbackValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String feedbackId=request.getParameter("id");
		FeedbackBean feedbackBean =FeedbackDAO.getfeedbackListByPK(Integer.parseInt(feedbackId));
		request.setAttribute("feedbackBean",feedbackBean);
		request.getRequestDispatcher("feedbackUpdate.jsp").forward(request, response);

	}

}
