package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.ReservationBean;
import com.digimation.gujjubus.bean.ReservationDetailBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class ReservationDAO {

	private  Connection conn;
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<ReservationBean> listOfReservationBeans;
	public  ArrayList<ReservationBean> getRegularReservationList()
	{
		listOfReservationBeans=new ArrayList<ReservationBean>();
	conn=MysqlConnection.getConnection();
		ReservationBean reservationBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select s.journey_date,s.user_id,u.first_name,u.middle_name," +
					"u.last_name,u.email,source_id,destination_id,reservation_id,is_cancel,ss.station_name " +
					"as source,s.no_of_seat,s.total_amount,s.bus_no,s.distance" +
					",sd.station_name as destination from reservation s,station ss,user u," +
					"station sd ,bus bs where s.source_id=ss.station_id and" +
					" s.destination_id=sd.station_id and s.bus_no=bs.bus_no and s.user_id=u.user_id" +
					" and is_cancel='n' and s.res_date=curdate()");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				reservationBeanObj=new ReservationBean();
				reservationBeanObj.setReservationId(rs.getInt("reservation_id"));
				reservationBeanObj.setDestination((rs.getString("destination")));
				reservationBeanObj.setSource((rs.getString("source")));
				reservationBeanObj.setSourceId(rs.getInt("source_id"));
				reservationBeanObj.setDestinationId(rs.getInt("destination_id"));
				reservationBeanObj.setDistance(rs.getInt("distance"));
				reservationBeanObj.setTotalAmount(rs.getInt("total_amount"));
				reservationBeanObj.setIsCancel(rs.getString("is_cancel"));
				reservationBeanObj.setBusNo(rs.getString("bus_no"));
				reservationBeanObj.setNoOfSeat(rs.getInt("no_of_seat"));
				reservationBeanObj.setUserId(rs.getInt("user_id"));
				reservationBeanObj.setJourneyDate(rs.getDate("journey_date").toString());
				reservationBeanObj.setFirstName(rs.getString("first_name"));
				reservationBeanObj.setMiddleName(rs.getString("middle_name"));
				reservationBeanObj.setLastName(rs.getString("last_name"));
				reservationBeanObj.setEmail(rs.getString("email"));
				listOfReservationBeans.add(reservationBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationBeans;
	}

	
public  ArrayList<ReservationBean> getUserReservationList(int userID)
{
	listOfReservationBeans=new ArrayList<ReservationBean>();
conn=MysqlConnection.getConnection();
	ReservationBean reservationBeanObj=null;
	try {
		
			pstmt=conn.prepareStatement("select s.journey_date,s.user_id,u.first_name,u.middle_name," +
				"u.last_name,u.email,source_id,destination_id,reservation_id,is_cancel,ss.station_name " +
				"as source,s.no_of_seat,s.total_amount,s.bus_no,s.distance" +
				",sd.station_name as destination from reservation s,station ss,user u," +
				"station sd ,bus bs where s.source_id=ss.station_id and" +
				" s.destination_id=sd.station_id and s.bus_no=bs.bus_no and s.user_id=u.user_id" +
				" and is_cancel='n' and s.user_id=?");
		pstmt.setInt(1,	userID);
		 rs=pstmt.executeQuery();
		 while (rs.next()) 
		 {
			reservationBeanObj=new ReservationBean();
			reservationBeanObj.setReservationId(rs.getInt("reservation_id"));
			reservationBeanObj.setDestination((rs.getString("destination")));
			reservationBeanObj.setSource((rs.getString("source")));
			reservationBeanObj.setSourceId(rs.getInt("source_id"));
			reservationBeanObj.setDestinationId(rs.getInt("destination_id"));
			reservationBeanObj.setDistance(rs.getInt("distance"));
			reservationBeanObj.setTotalAmount(rs.getInt("total_amount"));
			reservationBeanObj.setIsCancel(rs.getString("is_cancel"));
			reservationBeanObj.setBusNo(rs.getString("bus_no"));
			reservationBeanObj.setNoOfSeat(rs.getInt("no_of_seat"));
			reservationBeanObj.setUserId(rs.getInt("user_id"));
			reservationBeanObj.setJourneyDate(rs.getDate("journey_date").toString());
			reservationBeanObj.setFirstName(rs.getString("first_name"));
			reservationBeanObj.setMiddleName(rs.getString("middle_name"));
			reservationBeanObj.setLastName(rs.getString("last_name"));
			reservationBeanObj.setEmail(rs.getString("email"));
			listOfReservationBeans.add(reservationBeanObj);
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}

	return listOfReservationBeans;
}

public  boolean cancelReservation(int resId)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {

		pstmt=conn.prepareStatement("update reservation set is_cancel='y'" +
					" where reservation_id=?");
		//pstmt.setString(1, reservationDetailBeanObj.getReservationDetail());
		pstmt.setInt(1,resId);
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

	public  boolean addReservation(ReservationBean reservationBeanObj)
	{
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into reservation(source_id,destination_id,bus_no," +
					"no_of_seat,total_amount,user_id," +
					"distance,journey_date,res_date) values(?,?,?,?,?,?,?,?,curdate())");
			pstmt.setInt(1, reservationBeanObj.getSourceId());
			pstmt.setInt(2, reservationBeanObj.getDestinationId());
			pstmt.setString(3, reservationBeanObj.getBusNo());
			pstmt.setInt(4, reservationBeanObj.getNoOfSeat());
			pstmt.setInt(5, reservationBeanObj.getTotalAmount());
			pstmt.setInt(6, reservationBeanObj.getUserId());
			pstmt.setInt(7, reservationBeanObj.getDistance());
			pstmt.setString(8, reservationBeanObj.getJourneyDate());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	
	}


public  ReservationBean getReservationListByPK(int reservationId)
	{
	    conn=MysqlConnection.getConnection();
		ReservationBean reservationBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select s.journey_date,s.user_id,u.first_name,u.middle_name," +
					"u.last_name,u.email,source_id,destination_id,reservation_id,is_cancel,ss.station_name " +
					"as source,sd.station_name as destination,s.no_of_seat,s.total_amount,s.bus_no,s.distance" +
					",sd.station_name as destination from reservation s,station ss,user u," +
					"station sd ,bus bs where s.source_id=ss.station_id and" +
					" s.destination_id=sd.station_id and s.bus_no=bs.bus_no and s.user_id=u.user_id" +
					" and s.reservation_id=? and is_cancel='n'");
			pstmt.setInt(1, reservationId);
			rs=pstmt.executeQuery();
			 if (rs.next())
			 {
				reservationBeanObj=new ReservationBean();
				reservationBeanObj.setReservationId(reservationId);
				reservationBeanObj.setDestinationId(rs.getInt("destination_id"));
				reservationBeanObj.setSourceId(rs.getInt("source_id"));
				reservationBeanObj.setDestination(rs.getString("destination"));
				reservationBeanObj.setSource(rs.getString("source"));
				reservationBeanObj.setIsCancel(rs.getString("is_cancel"));
				reservationBeanObj.setBusNo(rs.getString("bus_no"));
				reservationBeanObj.setDistance(rs.getInt("distance"));
				reservationBeanObj.setNoOfSeat(rs.getInt("no_of_seat"));
				reservationBeanObj.setJourneyDate(rs.getString("journey_date"));
				reservationBeanObj.setTotalAmount(rs.getInt("total_amount"));
				reservationBeanObj.setFirstName(rs.getString("first_name"));
				reservationBeanObj.setMiddleName(rs.getString("middle_name"));
				reservationBeanObj.setLastName(rs.getString("last_name"));
				reservationBeanObj.setEmail(rs.getString("email"));
				reservationBeanObj.setUserId(rs.getInt("user_id"));
				
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return reservationBeanObj;
	}



public  boolean updateReservation(ReservationDetailBean reservationDetailBeanobj, ReservationBean reservationBeanObj)
	{
	 	int i=0;
	 	Savepoint p1=null;
		conn=MysqlConnection.getConnection();
		try {
			conn.setAutoCommit(false);
			p1=conn.setSavepoint();
			pstmt=conn.prepareStatement("update reservation set no_of_seat=?,is_cancel=?,journey_date=?,user_id=? where reservation_id=?");
			pstmt.setInt(1,reservationBeanObj.getNoOfSeat());
			pstmt.setString(2,reservationBeanObj.getIsCancel());
			pstmt.setString(3,reservationBeanObj.getJourneyDate());
			pstmt.setInt(4,reservationBeanObj.getUserId());
			pstmt.setInt(5,reservationBeanObj.getReservationId());
			i=pstmt.executeUpdate();
			p1=conn.setSavepoint();
		String seat[]=reservationDetailBeanobj.getSeatNo();	
		new ReservationDetailDAO().removeReservationDetailById(reservationBeanObj.getReservationId());
			for(int j=0;j<seat.length;j++){
				pstmt=conn.prepareStatement("insert into reservation_detail(reservation_id,seat_no,seat_type_id) values(" +
						"?,?,?)");
				pstmt.setInt(1,reservationBeanObj.getReservationId());
				pstmt.setInt(2,Integer.parseInt(seat[j]));
			pstmt.setInt(3,reservationDetailBeanobj.getSeatTypeId());
			p1=conn.setSavepoint();
			i=pstmt.executeUpdate();
			conn.setAutoCommit(true);
			}	
			
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				conn.rollback(p1);
				return false;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			return false;
			}
		}
	return true;
	}

public  boolean removeReservation(int reservationId)
{
conn=MysqlConnection.getConnection();
	int i=0;
	try {
		pstmt=conn.prepareStatement("delete  from reservation where reservation_id=?");
		pstmt.setInt(1, reservationId);
		 i=pstmt.executeUpdate();
	} catch (SQLException e) {

		e.printStackTrace();
	}
	if(i==0)
		return false;
else 
	return true;
}


public  ArrayList<ReservationBean> getReservationList()
{
	listOfReservationBeans=new ArrayList<ReservationBean>();
conn=MysqlConnection.getConnection();
	ReservationBean reservationBeanObj=null;
	try {
		pstmt=conn.prepareStatement("select s.journey_date,s.user_id,u.first_name,u.middle_name," +
				"u.last_name,u.email,source_id,destination_id,reservation_id,is_cancel,ss.station_name " +
				"as source,s.no_of_seat,s.total_amount,s.bus_no,s.distance" +
				",sd.station_name as destination from reservation s,station ss,user u," +
				"station sd ,bus bs where s.source_id=ss.station_id and" +
				" s.destination_id=sd.station_id and s.bus_no=bs.bus_no and s.user_id=u.user_id" +
				" and is_cancel='n'");
		 rs=pstmt.executeQuery();
		 while (rs.next()) {
			reservationBeanObj=new ReservationBean();
			reservationBeanObj.setReservationId(rs.getInt("reservation_id"));
			reservationBeanObj.setDestination((rs.getString("destination")));
			reservationBeanObj.setSource((rs.getString("source")));
			reservationBeanObj.setSourceId(rs.getInt("source_id"));
			reservationBeanObj.setDestinationId(rs.getInt("destination_id"));
			reservationBeanObj.setDistance(rs.getInt("distance"));
			reservationBeanObj.setTotalAmount(rs.getInt("total_amount"));
			reservationBeanObj.setIsCancel(rs.getString("is_cancel"));
			reservationBeanObj.setBusNo(rs.getString("bus_no"));
			reservationBeanObj.setNoOfSeat(rs.getInt("no_of_seat"));
			reservationBeanObj.setUserId(rs.getInt("user_id"));
			reservationBeanObj.setJourneyDate(rs.getDate("journey_date").toString());
			reservationBeanObj.setFirstName(rs.getString("first_name"));
			reservationBeanObj.setMiddleName(rs.getString("middle_name"));
			reservationBeanObj.setLastName(rs.getString("last_name"));
			reservationBeanObj.setEmail(rs.getString("email"));
			listOfReservationBeans.add(reservationBeanObj);
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}

	return listOfReservationBeans;
}





}
