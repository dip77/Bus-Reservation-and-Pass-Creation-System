package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.SeatTypeBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class SeatTypeDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<SeatTypeBean> listOfSeatTypeBeans;
public  boolean addSeatType(SeatTypeBean seatTypeBeanObj)
	{
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into seat_type(seat_type) values(?)");
			pstmt.setString(1, seatTypeBeanObj.getSeatType());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	
	}

public  ArrayList<SeatTypeBean> getSeatTypeList()
	{
		listOfSeatTypeBeans=new ArrayList<SeatTypeBean>();
	conn=MysqlConnection.getConnection();
		SeatTypeBean seatTypeBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from seat_type");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				seatTypeBeanObj=new SeatTypeBean();
				seatTypeBeanObj.setSeatTypeId(rs.getInt("seat_type_id"));
				seatTypeBeanObj.setSeatType(rs.getString("seat_type"));
				listOfSeatTypeBeans.add(seatTypeBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfSeatTypeBeans;
	}


public  SeatTypeBean getSeatTypeListByPK(int id)
	{
	    conn=MysqlConnection.getConnection();
		SeatTypeBean seatTypeBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from seat_type where seat_type_id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				seatTypeBeanObj=new SeatTypeBean();
				seatTypeBeanObj.setSeatTypeId(id);
				seatTypeBeanObj.setSeatType(rs.getString("seat_type"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return seatTypeBeanObj;
	}

public  boolean updateSeatType(SeatTypeBean seatTypeBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update seat_type set seat_type=? where seat_type_id=?");
			pstmt.setString(1, seatTypeBeanObj.getSeatType());
			pstmt.setInt(2, seatTypeBeanObj.getSeatTypeId());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

public  boolean removeSeatType(int id)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from seat_type where seat_type_id=?");
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
