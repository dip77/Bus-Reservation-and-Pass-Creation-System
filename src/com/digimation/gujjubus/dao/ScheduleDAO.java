package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.ScheduleBean;
import com.digimation.gujjubus.bean.ScheduleDetailBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class ScheduleDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<ScheduleBean> listOfScheduleBeans;
	private ArrayList<ScheduleDetailBean> listOfScheduleDetailBeans;
	public ArrayList<ScheduleDetailBean> getUserScheduleDetailList(int sourceId,int destinationId) {
		listOfScheduleDetailBeans = new ArrayList<ScheduleDetailBean>();
		conn = MysqlConnection.getConnection();
		ScheduleDetailBean ScheduleDetailBeanObj = null;
		try {
			String sql = "select bd.bus_no," +
					"sc.schedule_id,arrival_time,departure_time,time_taken"
					+ ",source_id,destination_id,off_date,"
					+ "distance,ss.station_name as source,week_off_day,"
					+ "sd.station_name as destination from bus_detail bd," +
					"schedule_detail s,station ss,"
					+ "station sd,schedule sc where s.source_id=ss.station_id and"
					+ " s.destination_id=sd.station_id and s.schedule_id=sc.schedule_id" +
					" and sc.bus_detail_id=bd.bus_detail_id and s.source_id=? and "
					+"s.destination_id=? and is_available='y'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sourceId);
			pstmt.setInt(2, destinationId);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				ScheduleDetailBeanObj = new ScheduleDetailBean();
				ScheduleDetailBeanObj.setScheduleId(rs.getInt("schedule_id"));
				ScheduleDetailBeanObj.setWeekOfDay(rs.getInt("week_off_day"));
				ScheduleDetailBeanObj.setDestination((rs.getString("destination")));
				ScheduleDetailBeanObj.setSource((rs.getString("source")));
				ScheduleDetailBeanObj.setSourceId(rs.getInt("source_id"));
				ScheduleDetailBeanObj.setDestinationId(rs.getInt("destination_id"));
				ScheduleDetailBeanObj.setScheduleId(rs.getInt("schedule_id"));
				ScheduleDetailBeanObj.setArrivalTime(rs.getString("arrival_time"));
				ScheduleDetailBeanObj.setDepartureTime(rs.getString("departure_time"));
				ScheduleDetailBeanObj.setTimeTaken(rs.getInt("time_taken"));
				ScheduleDetailBeanObj.setOffDate(rs.getString("off_date"));
				ScheduleDetailBeanObj.setDistance(rs.getInt("distance"));
				ScheduleDetailBeanObj.setBusNo(rs.getString("bus_no"));
				listOfScheduleDetailBeans.add(ScheduleDetailBeanObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
System.out.println("size"+listOfScheduleDetailBeans.size());
		return listOfScheduleDetailBeans;
	}

public  boolean addSchedule(ScheduleBean scheduleBeanObj)
	{
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into schedule(bus_no) values(?)");
			pstmt.setString(1, scheduleBeanObj.getBusNo());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	
	}

public  ArrayList<ScheduleBean> getScheduleList()
	{
		listOfScheduleBeans=new ArrayList<ScheduleBean>();
	conn=MysqlConnection.getConnection();
		ScheduleBean scheduleBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from schedule");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				scheduleBeanObj=new ScheduleBean();
				scheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				scheduleBeanObj.setBusNo(rs.getString("bus_no"));
				listOfScheduleBeans.add(scheduleBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfScheduleBeans;
	}


public  ScheduleBean getScheduleListByPK(int id)
	{
	    conn=MysqlConnection.getConnection();
		ScheduleBean scheduleBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from schedule where schedule_id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				scheduleBeanObj=new ScheduleBean();
				scheduleBeanObj.setScheduleId(id);
				scheduleBeanObj.setBusNo(rs.getString("bus_no"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return scheduleBeanObj;
	}

public  boolean updateSchedule(ScheduleBean scheduleBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update schedule set bus_no=? where schedule_id=?");
			pstmt.setString(1, scheduleBeanObj.getBusNo());
			pstmt.setInt(2, scheduleBeanObj.getScheduleId());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

public  boolean removeSchedule(int id)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from schedule where schedule_id=?");
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
