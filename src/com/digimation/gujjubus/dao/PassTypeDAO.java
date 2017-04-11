package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.PassTypeBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class PassTypeDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<PassTypeBean> listOfPassTypeBeans;
	
	public boolean checkReference(int busNo)
	{
		try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from pass where pass_type_id=?");
			pstmt.setInt(1, busNo);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}

public  boolean addPassType(PassTypeBean passTypeBeanObj)
	{
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into pass_type(pass_type) values(?)");
			pstmt.setString(1, passTypeBeanObj.getPassType());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	
	}

public  ArrayList<PassTypeBean> getPassTypeList()
	{
		listOfPassTypeBeans=new ArrayList<PassTypeBean>();
	conn=MysqlConnection.getConnection();
		PassTypeBean passCategoryBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from pass_type");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				passCategoryBeanObj=new PassTypeBean();
				passCategoryBeanObj.setPassTypeId(rs.getInt("pass_type_id"));
				passCategoryBeanObj.setPassType(rs.getString("pass_type"));
				listOfPassTypeBeans.add(passCategoryBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfPassTypeBeans;
	}


public  PassTypeBean getPassTypeListByPK(int id)
	{
	    conn=MysqlConnection.getConnection();
		PassTypeBean passTypeBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from pass_type where pass_type_id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				passTypeBeanObj=new PassTypeBean();
				passTypeBeanObj.setPassTypeId(id);
				passTypeBeanObj.setPassType(rs.getString("pass_type"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return passTypeBeanObj;
	}

public  boolean updatePassType(PassTypeBean passTypeBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update pass_type set pass_type=? where pass_type_id=?");
			pstmt.setString(1, passTypeBeanObj.getPassType());
			pstmt.setInt(2, passTypeBeanObj.getPassTypeId());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

public  boolean removePassType(int id)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from pass_type where pass_type_id=?");
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
