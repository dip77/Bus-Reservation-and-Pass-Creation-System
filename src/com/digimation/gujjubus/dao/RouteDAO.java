package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.RouteBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class RouteDAO {
	private  Connection conn;
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<RouteBean> listOfRouteBeans;
	private ArrayList<RouteBean> listOfBusDetailBeans;
	public ArrayList<RouteBean> getDistinctBusNo(int id) {
		listOfBusDetailBeans = new ArrayList<RouteBean>();
		conn = MysqlConnection.getConnection();
		RouteBean routeBean = null;
		try {
			pstmt = conn.prepareStatement("select distinct bus_no from bus_detail where route_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				routeBean = new RouteBean();
			//	busDetailBeanObj.setBusDetailid(rs.getInt("bus_detail_id"));
				//busDetailBeanObj.setBusNo(rs.getString("bus_no"));
				routeBean.setBusNo(rs.getString("bus_no"));
				//busDetailBeanObj.setSource(rs.getString("source"));
				//busDetailBeanObj.setDestination(rs.getString("destination"));
				listOfBusDetailBeans.add(routeBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfBusDetailBeans;
	}

	public  RouteBean getRouteByPK2(int id)
	{
		listOfRouteBeans=new ArrayList<RouteBean>();
	conn=MysqlConnection.getConnection();
		RouteBean routeBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select source_id,destination_id,route_id,is_available,ss.station_name as source," +
					"sd.station_name as destination from route s,station ss," +
					"station sd where s.source_id=ss.station_id and" +
					" s.destination_id=sd.station_id and route_id=?");
			pstmt.setInt(1, id);
			 rs=pstmt.executeQuery();
			rs.next();
			 routeBeanObj=new RouteBean();
				routeBeanObj.setRouteId(rs.getInt("route_id"));
				routeBeanObj.setIsAvailable(rs.getString("is_available"));
				routeBeanObj.setDestination((rs.getString("destination")));
				routeBeanObj.setSource((rs.getString("source")));
				routeBeanObj.setSourceId(rs.getInt("source_id"));
				routeBeanObj.setDestinationId(rs.getInt("destination_id"));
				
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return routeBeanObj;
	}

	public boolean isExists(int s,int d)
	{
		try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from route where source_id=? and destination_id=?");
			pstmt.setInt(1, s);
			pstmt.setInt(2, d);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}

	public boolean checkReference(int busNo)
	{
		try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from bus_detail where route_id=?");
			pstmt.setInt(1, busNo);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}

	public  boolean addRoute(RouteBean routeBeanObj) {
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into route(source_id,destination_id) values(?,?)");
			pstmt.setInt(1, routeBeanObj.getSourceId());
			pstmt.setInt(2, routeBeanObj.getDestinationId());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	

		
	}


public  RouteBean getRouteListByPK(int routeId)
	{
	    conn=MysqlConnection.getConnection();
		RouteBean routeBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from route where route_id=?");
			pstmt.setInt(1, routeId);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				routeBeanObj=new RouteBean();
				routeBeanObj.setRouteId(routeId);
				routeBeanObj.setDestinationId(rs.getInt("destination_id"));
				routeBeanObj.setSourceId(rs.getInt("source_id"));
				routeBeanObj.setIsAvailable(rs.getString("is_available"));
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return routeBeanObj;
	}



public  boolean updateRoute(RouteBean routeBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update route set source_id=?,destination_id=?,is_available=?" +
					" where route_id=?");
			pstmt.setInt(1, routeBeanObj.getSourceId());
			pstmt.setInt(2,routeBeanObj.getDestinationId());
			pstmt.setString(3,routeBeanObj.getIsAvailable());
			pstmt.setInt(4,routeBeanObj.getRouteId());
			

			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}



public  boolean removeRoute(int routeId)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from route where route_id=?");
			pstmt.setInt(1, routeId);
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
			return false;
	else 
		return true;
	}




public  ArrayList<RouteBean> getRouteList()
	{
		listOfRouteBeans=new ArrayList<RouteBean>();
	conn=MysqlConnection.getConnection();
		RouteBean routeBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select source_id,destination_id,route_id,is_available,ss.station_name as source," +
					"sd.station_name as destination from route s,station ss," +
					"station sd where s.source_id=ss.station_id and" +
					" s.destination_id=sd.station_id");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				routeBeanObj=new RouteBean();
				routeBeanObj.setRouteId(rs.getInt("route_id"));
				routeBeanObj.setIsAvailable(rs.getString("is_available"));
				routeBeanObj.setDestination((rs.getString("destination")));
				routeBeanObj.setSource((rs.getString("source")));
				routeBeanObj.setSourceId(rs.getInt("source_id"));
				routeBeanObj.setDestinationId(rs.getInt("destination_id"));
				listOfRouteBeans.add(routeBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfRouteBeans;
	}




}
