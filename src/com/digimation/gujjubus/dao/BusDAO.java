package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.digimation.gujjubus.bean.BusBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class BusDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<BusBean> listOfBusBeans;
	public boolean checkReference(String busNo)
	{
		try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from bus_detail where bus_no=?");
			pstmt.setString(1, busNo);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;
				pstmt=conn.prepareStatement("select * from schedule where bus_no=?");
				pstmt.setString(1, busNo);
				rs=pstmt.executeQuery();
				 if(rs.next())
					 return true;		 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}
	public  boolean addBus(BusBean busBeanObj) {
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into bus(bus_no,capacity,bus_type_id,bus_depo_id,bus_category_id) values(?,?,?,?,?)");
			pstmt.setString(1, busBeanObj.getBusNo());
			pstmt.setInt(3, busBeanObj.getBusTypeId());
			pstmt.setInt(4, busBeanObj.getBusDepoId());
			pstmt.setInt(5, busBeanObj.getBusCategoryId());
			pstmt.setInt(2, busBeanObj.getCapacity());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	

		
	}



public  BusBean getBusListByPK(String busNo)
	{
	    conn=MysqlConnection.getConnection();
		BusBean busBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from bus where bus_no=?");
			pstmt.setString(1, busNo);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				busBeanObj=new BusBean();
				busBeanObj.setBusNo(busNo);
				busBeanObj.setCapacity(rs.getInt("capacity"));
			    busBeanObj.setBusCategoryId(rs.getInt("bus_category_id"));
			    busBeanObj.setBusDepoId(rs.getInt("bus_depo_id"));
			    busBeanObj.setBusTypeId(rs.getInt("bus_type_id"));
			    busBeanObj.setIsAvailable(rs.getString("is_available"));
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return busBeanObj;
	}



public  boolean updateBus(BusBean busBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update bus set capacity=?,is_available=?,bus_depo_id=?,bus_type_id=?," +
					"bus_category_id=? where bus_no=?");
			pstmt.setString(2, busBeanObj.getIsAvailable());
			pstmt.setInt(1, busBeanObj.getCapacity());
			pstmt.setInt(3,busBeanObj.getBusDepoId());
			pstmt.setInt(4,busBeanObj.getBusTypeId());
			pstmt.setInt(5,busBeanObj.getBusCategoryId());
			pstmt.setString(6, busBeanObj.getBusNo());

			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}



public  boolean removeBus(String busNo)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from bus where bus_no=?");
			pstmt.setString(1, busNo);
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
			return false;
	else 
		return true;
	}



public  ArrayList<BusBean> getBusList()
	{
		listOfBusBeans=new ArrayList<BusBean>();
	conn=MysqlConnection.getConnection();
		BusBean busBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from bus,bus_type,bus_category,city " +
					"where bus.bus_type_id=bus_type.bus_type_id and " +
					"bus.bus_category_id=bus_category.bus_category_id and "+ 
					"bus.bus_depo_id=city.city_id");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				busBeanObj=new BusBean();
				busBeanObj.setBusNo(rs.getString("bus_no"));
				busBeanObj.setCapacity(rs.getInt("capacity"));
				busBeanObj.setIsAvailable(rs.getString("is_available"));
				busBeanObj.setBusCategory(rs.getString("bus_category"));
				busBeanObj.setBusDepo(rs.getString("city_name"));
				busBeanObj.setBusType(rs.getString("bus_type"));
				listOfBusBeans.add(busBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfBusBeans;
	}


}
