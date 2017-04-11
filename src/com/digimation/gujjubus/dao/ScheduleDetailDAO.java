package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import com.digimation.gujjubus.bean.ScheduleDetailBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class ScheduleDetailDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<ScheduleDetailBean> listOfScheduleDetailBeans;

	public int getStationId(String station) {
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("select station_id from station where station_name=?");
			pstmt.setString(1, station);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("station_id");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public boolean addScheduleDetail(ScheduleDetailBean scheduleBeanObj) {
		conn = MysqlConnection.getConnection();
		Savepoint p1 = null;
		int i;
		try {
			conn.setAutoCommit(false);
			p1 = conn.setSavepoint();
			pstmt = conn
					.prepareStatement("insert into schedule(bus_detail_id) values(?)");
			pstmt.setInt(1, scheduleBeanObj.getBusDetailId());
			i = pstmt.executeUpdate();
			String sql = "insert into schedule_detail(schedule_id,source_id,"
					+ "destination_id,distance,week_off_day,off_date,arrival_time,departure_time,"
					+ "time_taken) values(last_insert_id(),?,?,?,?,?,?,?,"
					+ "floor(-time_to_sec(timediff(\""
					+ scheduleBeanObj.getDepartureTime() + "\",\""
					+ scheduleBeanObj.getReachTime() + "\"))/60))";
			p1 = conn.setSavepoint();	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scheduleBeanObj.getSourceId());
			pstmt.setInt(2, scheduleBeanObj.getDestinationId());
			pstmt.setInt(3, scheduleBeanObj.getDistance());
			pstmt.setInt(4, scheduleBeanObj.getWeekOfDay());
			pstmt.setString(5, scheduleBeanObj.getOffDate());
			pstmt.setString(6, scheduleBeanObj.getArrivalTime());
			pstmt.setString(7, scheduleBeanObj.getDepartureTime());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			try {
				conn.rollback(p1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public ScheduleDetailBean getScheduleDetailListByPK(int scheduleDetailId) {
		conn = MysqlConnection.getConnection();
		ScheduleDetailBean scheduleDetailBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select bd.bus_no,ss.station_name as source,sd.station_name as " +
							" destination,sc.source_id,sc.destination_id,sc.distance,sc.time_taken," +
							"sc.week_off_day,sc.off_date,sc.arrival_time,sc.departure_time" +
							" from bus_detail bd,schedule s,schedule_detail sc,station ss,station sd " +
							"where sc.source_id=ss.station_id and sc.destination_id=sd.station_id" +
							" and sc.schedule_id=s.schedule_id and s.bus_detail_id=bd.bus_detail_id" +
							" and sc.schedule_id=?");
			pstmt.setInt(1, scheduleDetailId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				scheduleDetailBeanObj = new ScheduleDetailBean();
				scheduleDetailBeanObj.setScheduleId(scheduleDetailId);
				scheduleDetailBeanObj.setBusNo(rs.getString("bus_no"));
				scheduleDetailBeanObj.setDestinationId(rs.getInt("destination_id"));
				scheduleDetailBeanObj.setSourceId(rs.getInt("source_id"));
				scheduleDetailBeanObj.setDistance(rs.getInt("distance"));
				scheduleDetailBeanObj.setWeekOfDay(rs.getInt("week_off_day"));
				scheduleDetailBeanObj.setOffDate(rs.getString("off_date"));
				scheduleDetailBeanObj.setArrivalTime(rs.getString("arrival_time"));
				scheduleDetailBeanObj.setDepartureTime(rs.getString("departure_time"));
				scheduleDetailBeanObj.setTimeTaken(rs.getInt("time_taken"));
				scheduleDetailBeanObj.setSource(rs.getString("source"));
				scheduleDetailBeanObj.setDestination(rs.getString("destination"));
				String sql="SELECT ADDTIME(\""+scheduleDetailBeanObj.getDepartureTime()+
						"\", SEC_TO_TIME("+scheduleDetailBeanObj.getTimeTaken()+"*60)) as reach_time";
				pstmt=conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				scheduleDetailBeanObj.setReachTime(rs.getString("reach_time"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return scheduleDetailBeanObj;
	}

	public boolean updateScheduleDetail(ScheduleDetailBean scheduleDetailBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			String sql="update schedule_detail set source_id=?,destination_id=?,distance=?"
					+ ",week_off_day=?,off_date=?,arrival_time=?,departure_time=?,time_taken=" +
					"floor(-time_to_sec(timediff(\""
					+ scheduleDetailBeanObj.getDepartureTime() + "\",\""
					+ scheduleDetailBeanObj.getReachTime() + "\"))/60)"+		
					" where schedule_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scheduleDetailBeanObj.getSourceId());
			pstmt.setInt(2, scheduleDetailBeanObj.getDestinationId());
			pstmt.setInt(3, scheduleDetailBeanObj.getDistance());
			pstmt.setInt(4, scheduleDetailBeanObj.getWeekOfDay());
			pstmt.setInt(8, scheduleDetailBeanObj.getScheduleId());
			pstmt.setString(6,scheduleDetailBeanObj.getArrivalTime());
			pstmt.setString(7,scheduleDetailBeanObj.getDepartureTime() );
			pstmt.setString(5, scheduleDetailBeanObj.getOffDate());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeScheduleDetail(int scheduleDetailId) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("delete  from schedule_detail where schedule_id=?");
			pstmt.setInt(1, scheduleDetailId);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public ArrayList<ScheduleDetailBean> getscheduleDetailList() {
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
					" and sc.bus_detail_id=bd.bus_detail_id";
			pstmt = conn.prepareStatement(sql);
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

}
