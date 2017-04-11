package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.BusCategoryBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class BusCategoryDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<BusCategoryBean> listOfBusCategoryBeans;
	
	public boolean checkReference(int busNo)
	{
		try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from bus where bus_category_id=?");
			pstmt.setInt(1, busNo);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}
	public  boolean addBusCategory(BusCategoryBean busCategoryBeanObj)
	{
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into bus_category(bus_category) values(?)");
			pstmt.setString(1, busCategoryBeanObj.getBusCategory());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	
	}

public  ArrayList<BusCategoryBean> getBusCategoryList()
	{
		listOfBusCategoryBeans=new ArrayList<BusCategoryBean>();
	conn=MysqlConnection.getConnection();
		BusCategoryBean busCategoryBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from bus_category");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				busCategoryBeanObj=new BusCategoryBean();
				busCategoryBeanObj.setBusCategoryId(rs.getInt("bus_category_id"));
				busCategoryBeanObj.setBusCategory(rs.getString("bus_category"));
				listOfBusCategoryBeans.add(busCategoryBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfBusCategoryBeans;
	}


public  BusCategoryBean getBusCategoryListByPK(int id)
	{
	    conn=MysqlConnection.getConnection();
		BusCategoryBean busCategoryBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from bus_category where bus_category_id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				busCategoryBeanObj=new BusCategoryBean();
				busCategoryBeanObj.setBusCategoryId(id);
				busCategoryBeanObj.setBusCategory(rs.getString("bus_category"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return busCategoryBeanObj;
	}

public  boolean updateBusCategory(BusCategoryBean busCategoryBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update bus_category set bus_category=? where bus_category_id=?");
			pstmt.setString(1, busCategoryBeanObj.getBusCategory());
			pstmt.setInt(2, busCategoryBeanObj.getBusCategoryId());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

public  boolean removeBusCategory(int id)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from bus_category where bus_category_id=?");
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
