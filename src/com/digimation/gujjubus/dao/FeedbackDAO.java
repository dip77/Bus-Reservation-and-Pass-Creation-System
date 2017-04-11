package com.digimation.gujjubus.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.digimation.gujjubus.bean.FeedbackBean;
import com.digimation.gujjubus.util.MysqlConnection;
public class FeedbackDAO {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static ArrayList<FeedbackBean> listOfFeedbackBeans;

	public static boolean addFeedback(FeedbackBean feedbackBean) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into feedback(user_id,feedback) values(?,?)");
			pstmt.setInt(1, feedbackBean.getUserId());
			pstmt.setString(2, feedbackBean.getFeedback());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}
	public static ArrayList<FeedbackBean> getFeedbackList() {
		listOfFeedbackBeans = new ArrayList<FeedbackBean>();
		conn = MysqlConnection.getConnection();
		FeedbackBean feedbackBean = null;
		try {
			pstmt = conn.prepareStatement("select * from Feedback");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				feedbackBean = new FeedbackBean();
				feedbackBean.setFeedbackId(rs.getInt("feedback_id"));
				feedbackBean.setFeedback(rs.getString("feedback"));
				feedbackBean.setUserId(rs.getInt("user_id"));
				listOfFeedbackBeans.add(feedbackBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listOfFeedbackBeans;
	}
	public static FeedbackBean getfeedbackListByPK(int id) {
		conn = MysqlConnection.getConnection();
		FeedbackBean feedbackBean = null;
		try {
			pstmt = conn
					.prepareStatement("select * from feedback where feedback_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				feedbackBean = new FeedbackBean();
				feedbackBean.setFeedbackId(id);
				feedbackBean.setFeedback(rs.getString("Feedback"));
				feedbackBean.setUserId(rs.getInt("user_id"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return feedbackBean;
	}
	public static boolean updateFeedback(FeedbackBean feedbackBean) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update feedback set feedback=? where feedback_id=?");
			pstmt.setString(1, feedbackBean.getFeedback());
			pstmt.setInt(2, feedbackBean.getFeedbackId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}
	public static boolean removeFeedback(int id) {
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("delete  from feedback where feedback_id=?");
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}
}
