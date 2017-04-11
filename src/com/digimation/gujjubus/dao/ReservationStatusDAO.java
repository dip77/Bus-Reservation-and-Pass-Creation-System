package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.ReservationStatusBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class ReservationStatusDAO {

	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<ReservationStatusBean> listOfReservationStatusBeans;

	public  boolean addReservationStatus(ReservationStatusBean reservationStatusBean)
	{
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into reservation_status(res_status) values(?)");
			pstmt.setString(1, reservationStatusBean.getReservationStatus());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	
	}

public  ArrayList<ReservationStatusBean> getReservationStatusList()
	{
		listOfReservationStatusBeans=new ArrayList<ReservationStatusBean>();
	conn=MysqlConnection.getConnection();
		ReservationStatusBean reservationStatusBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from reservation_status");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				reservationStatusBeanObj=new ReservationStatusBean();
				reservationStatusBeanObj.setReservationStatusId(rs.getInt("res_status_id"));
				reservationStatusBeanObj.setReservationStatus(rs.getString("res_status"));
				listOfReservationStatusBeans.add(reservationStatusBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationStatusBeans;
	}


public  ReservationStatusBean getReservationStatusListByPK(int id)
	{
	    conn=MysqlConnection.getConnection();
		ReservationStatusBean reservation_statusBean=null;
		try {
			pstmt=conn.prepareStatement("select * from reservation_status where res_status_id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				reservation_statusBean=new ReservationStatusBean();
				reservation_statusBean.setReservationStatusId(id);
				reservation_statusBean.setReservationStatus(rs.getString("res_status"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return reservation_statusBean;
	}

public  boolean updateReservationStatus(ReservationStatusBean reservation_statusBean)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update reservation_status set res_status=? where res_status_id=?");
			pstmt.setString(1, reservation_statusBean.getReservationStatus());
			pstmt.setInt(2, reservation_statusBean.getReservationStatusId());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

public  boolean removeReservationStatus(int id)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from reservation_status where res_status_id=?");
			pstmt.setInt(1, id);
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
			return false;
	else 
		return true;
	}


}
