package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.StationBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class StationDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<StationBean> listOfStationBeans;

	
	public boolean checkReference(int cityId)
	{
		try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from station where station_id=?");
			pstmt.setInt(1, cityId);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;		
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}


public  boolean addStation(StationBean stationBeanObj)
	{
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into station(station_name,city_id) values(?,?)");
			pstmt.setString(1, stationBeanObj.getStationName());
			pstmt.setString(2, stationBeanObj.getCityName());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	
	}


public  ArrayList<StationBean> getStationList()
	{
		listOfStationBeans=new ArrayList<StationBean>();
	conn=MysqlConnection.getConnection();
		StationBean stationBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from station,city where station.city_id=city.city_id");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				stationBeanObj=new StationBean();
				stationBeanObj.setStationId(rs.getInt("station_id"));
				stationBeanObj.setStationName(rs.getString("station_name"));
				stationBeanObj.setCityName(rs.getString("city_name"));
				
				listOfStationBeans.add(stationBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfStationBeans;
	}


public  StationBean getStationListByPK(int stationId)
	{
	    conn=MysqlConnection.getConnection();
		StationBean stationBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from station where station_id=?");
			pstmt.setInt(1, stationId);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				stationBeanObj=new StationBean();
				stationBeanObj.setStationId(stationId);
				stationBeanObj.setStationName(rs.getString("station_name"));
				stationBeanObj.setCityId(rs.getInt("city_id"));
				
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return stationBeanObj;
	}
public  boolean updateStation(StationBean stationBeanObj)
{
 	int i=0;
	conn=MysqlConnection.getConnection();
	try {
		pstmt=conn.prepareStatement("update station set station_name=?,city_id=? where station_id=?");
		pstmt.setString(1, stationBeanObj.getStationName());
		pstmt.setInt(2, stationBeanObj.getCityId());
		pstmt.setInt(3, stationBeanObj.getStationId());
		 i=pstmt.executeUpdate();
	} catch (SQLException e) {

		e.printStackTrace();
	}
if(i==0)
	return false;
else
return true;
}


public  boolean removeStation(int id)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from station where station_id=?");
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


