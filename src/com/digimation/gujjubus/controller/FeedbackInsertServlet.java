package com.digimation.gujjubus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.FeedbackBean;
import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.FeedbackDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class FeedbackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String feedback = request.getParameter("txtfeedback");
		HttpSession session=request.getSession();
		UserBean userBean=(UserBean)session.getAttribute("userBean");
		boolean isEmpty = false;	
		if (ValidateUtils.isEmpty(feedback)) {
			request.setAttribute("feedback", "Plaese Enter some feedback");
			isEmpty = true;
		}
		if (isEmpty) {

			request.getRequestDispatcher("feedbackInsert.jsp").forward(request,
					response);
		} else {
			FeedbackBean feedbackBean = new FeedbackBean();
			feedbackBean.setFeedback(feedback);
			feedbackBean.setUserId(userBean.getUserId());
			if (FeedbackDAO.addFeedback(feedbackBean)) {
				request.setAttribute("msgreservation", " successfully done");
				request.getRequestDispatcher("UserHomePage.jsp").forward(
						request, response);
			} else {
				request.setAttribute("msgfeedback", "failed to add feedback ");
				request.getRequestDispatcher("UserContact-Us.jsp").forward(
						request, response);
			}
		}
	}
}
