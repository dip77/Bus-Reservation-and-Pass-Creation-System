package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.digimation.gujjubus.bean.BusTypeBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class BusTypeDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<BusTypeBean> listOfBusTypeBeans;
	public boolean checkReference(int busNo)
	{
		try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from bus where bus_type_id=?");
			pstmt.setInt(1, busNo);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}
public  boolean addBusType(BusTypeBean busTypeBeanObj)
	{
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into bus_type(bus_type) values(?)");
			pstmt.setString(1, busTypeBeanObj.getBusType());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	
	}

public  ArrayList<BusTypeBean> getBusTypeList()
	{
		listOfBusTypeBeans=new ArrayList<BusTypeBean>();
	conn=MysqlConnection.getConnection();
		BusTypeBean busTypeBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from bus_type");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				busTypeBeanObj=new BusTypeBean();
				busTypeBeanObj.setBusTypeId(rs.getInt("bus_type_id"));
				busTypeBeanObj.setBusType(rs.getString("bus_type"));
				listOfBusTypeBeans.add(busTypeBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfBusTypeBeans;
	}


public  BusTypeBean getBusTypeListByPK(int id)
	{
	    conn=MysqlConnection.getConnection();
		BusTypeBean busTypeBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from bus_type where bus_type_id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				busTypeBeanObj=new BusTypeBean();
				busTypeBeanObj.setBusTypeId(id);
				busTypeBeanObj.setBusType(rs.getString("bus_type"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return busTypeBeanObj;
	}

public  boolean updateBusType(BusTypeBean busTypeBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update bus_type set bus_type=? where bus_type_id=?");
			pstmt.setString(1, busTypeBeanObj.getBusType());
			pstmt.setInt(2, busTypeBeanObj.getBusTypeId());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

public  boolean removeBusType(int id)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from bus_type where bus_type_id=?");
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
