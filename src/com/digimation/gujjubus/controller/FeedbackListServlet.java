package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.FeedbackBean;
import com.digimation.gujjubus.dao.FeedbackDAO;

public class FeedbackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
 	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<FeedbackBean> listOfFeedbackBeans=FeedbackDAO.getFeedbackList();
			request.setAttribute("listoffeedback", listOfFeedbackBeans);
			request.getRequestDispatcher("UserFeedBackList.jsp").forward(request, response);
	 }
}
