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

public class ReservationDetailDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<ReservationDetailBean> listOfReservationDetailBeans;
	
public  boolean addReservationDetail(ReservationDetailBean reservationDetailBeanObj,ReservationBean reservationBeanObj)
	{
		conn=MysqlConnection.getConnection();
		Savepoint p1=null;
		int i=0;
		try {
			conn.setAutoCommit(false);
			p1=conn.setSavepoint();
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
			p1=conn.setSavepoint();
			String []seat= reservationDetailBeanObj.getSeatNo();
			for(int j=0;j<reservationDetailBeanObj.getSeatNo().length;j++)	
			{		
			pstmt=conn.prepareStatement("insert into reservation_detail(reservation_id,seat_no,seat_type_id) values(last_" +
					"insert_id(),?,?)");
			pstmt.setString(1,seat[j]);
			pstmt.setInt(2, reservationDetailBeanObj.getSeatTypeId());
			 i=pstmt.executeUpdate();
			}
			
			} catch (SQLException e) {
			try {
				conn.rollback(p1);
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		return false;
		}
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return true;
	}


public  ArrayList<ReservationDetailBean> getReservationSeats2(ReservationBean reservationBean)
	{
		listOfReservationDetailBeans=new ArrayList<ReservationDetailBean>();
	conn=MysqlConnection.getConnection();
		ReservationDetailBean reservationDetailBeanObj=null;
		try {
			/*pstmt=conn.prepareStatement("select  ss.station_name as source,sd.station_name as" +
					" destination, u.first_name,u.middle_name,u.last_name,u.email," +
					"r.total_amount,r.no_of_seat,r.bus_no,r.distance,r.journey_date"+
					" from reservation_detail rd,reservation r,station ss,station sd" +
					",user u where r.reservation_id=rd.reservation_id and " +
					"u.user_id=r.user_id and r.source_id=ss.station_id and r.destination_id=" +
					"sd.station_id");*/
			pstmt=conn.prepareStatement("select rd.seat_no,rd.seat_type_id from reservation_detail rd," +
					"reservation r where r.journey_date=?" +
					" and bus_no=? and r.reservation_id=rd.reservation_id" +
					" and is_cancel='n'");
			pstmt.setString(1, reservationBean.getJourneyDate());	
			pstmt.setString(2, reservationBean.getBusNo());
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				reservationDetailBeanObj=new ReservationDetailBean();
			//	reservationDetailBeanObj.setReservationId(rs.getInt("reservation_id"));
				reservationDetailBeanObj.setSeatNum(rs.getInt("seat_no"));
				reservationDetailBeanObj.setSeatTypeId(rs.getInt("seat_type_id"));
				//reservationDetailBeanObj.setAmount(rs.getInt("total_amount"));
				//reservationDetailBeanObj.setBusNo(rs.getString("bus_no"));
				//reservationDetailBeanObj.setDestination(rs.getString("source"));
				//reservationDetailBeanObj.setSource(rs.getString("destination"));
				//reservationDetailBeanObj.setDistance(rs.getInt("distance"));
				//reservationDetailBeanObj.setEmail(rs.getString("email"));
				//reservationDetailBeanObj.setFirstName(rs.getString("first_name"));
				//reservationDetailBeanObj.setMiddleName(rs.getString("middle_name"));
				//reservationDetailBeanObj.setLastName(rs.getString("last_name"));
				//reservationDetailBeanObj.setJourneyDate(rs.getString("journey_date"));
				listOfReservationDetailBeans.add(reservationDetailBeanObj);
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationDetailBeans;
	}





public  ArrayList<ReservationDetailBean> getReservationSeats(ReservationBean reservationBean)
	{
		listOfReservationDetailBeans=new ArrayList<ReservationDetailBean>();
	conn=MysqlConnection.getConnection();
		ReservationDetailBean reservationDetailBeanObj=null;
		try {
			/*pstmt=conn.prepareStatement("select  ss.station_name as source,sd.station_name as" +
					" destination, u.first_name,u.middle_name,u.last_name,u.email," +
					"r.total_amount,r.no_of_seat,r.bus_no,r.distance,r.journey_date"+
					" from reservation_detail rd,reservation r,station ss,station sd" +
					",user u where r.reservation_id=rd.reservation_id and " +
					"u.user_id=r.user_id and r.source_id=ss.station_id and r.destination_id=" +
					"sd.station_id");*/
			pstmt=conn.prepareStatement("select rd.seat_no,rd.seat_type_id from reservation_detail rd," +
					"reservation r where r.journey_date=?" +
					" and bus_no=? and r.reservation_id=rd.reservation_id" +
					" and is_cancel='n'");
			pstmt.setString(1, reservationBean.getJourneyDate());	
			pstmt.setString(2, reservationBean.getBusNo());
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				reservationDetailBeanObj=new ReservationDetailBean();
			//	reservationDetailBeanObj.setReservationId(rs.getInt("reservation_id"));
				reservationDetailBeanObj.setSeatNum(rs.getInt("seat_no"));
				reservationDetailBeanObj.setSeatTypeId(rs.getInt("seat_type_id"));
				//reservationDetailBeanObj.setAmount(rs.getInt("total_amount"));
				//reservationDetailBeanObj.setBusNo(rs.getString("bus_no"));
				//reservationDetailBeanObj.setDestination(rs.getString("source"));
				//reservationDetailBeanObj.setSource(rs.getString("destination"));
				//reservationDetailBeanObj.setDistance(rs.getInt("distance"));
				//reservationDetailBeanObj.setEmail(rs.getString("email"));
				//reservationDetailBeanObj.setFirstName(rs.getString("first_name"));
				//reservationDetailBeanObj.setMiddleName(rs.getString("middle_name"));
				//reservationDetailBeanObj.setLastName(rs.getString("last_name"));
				//reservationDetailBeanObj.setJourneyDate(rs.getString("journey_date"));
				listOfReservationDetailBeans.add(reservationDetailBeanObj);
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationDetailBeans;
	}



public  ArrayList<ReservationDetailBean> getReservationDetailListByPK(int id)
	{
	    conn=MysqlConnection.getConnection();
		ReservationDetailBean reservationDetailBeanObj=null;
		try {
		listOfReservationDetailBeans=new ArrayList<ReservationDetailBean>();
			pstmt=conn.prepareStatement("select * from reservation_detail where reservation_id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				reservationDetailBeanObj=new ReservationDetailBean();
				reservationDetailBeanObj.setReservationId(id);
				reservationDetailBeanObj.setSeatNum(rs.getInt("seat_no"));
				reservationDetailBeanObj.setSeatTypeId(rs.getInt("seat_type_id"));
				listOfReservationDetailBeans.add(reservationDetailBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationDetailBeans;
	}

public  boolean updateReservationDetail(ReservationDetailBean reservationDetailBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update reservation_detail set reservation_id=?,seat_no=?,seat_type_id=?" +
					" where reservation_id=?");
		//	pstmt.setString(1, reservationDetailBeanObj.getReservationDetail());
		//	pstmt.setInt(2, reservationDetailBeanObj.getReservationDetailId());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

public  boolean removeReservationDetail(int id)
	{
	conn=MysqlConnection.getConnection();
	Savepoint p1=null;		
	int i=0;
		try {
			conn.setAutoCommit(false);
			p1=conn.setSavepoint();
				pstmt=conn.prepareStatement("delete  from reservation_detail where reservation_id=?");
			pstmt.setInt(1, id);
			 i=pstmt.executeUpdate();
				p1=conn.setSavepoint();
			 pstmt=conn.prepareStatement("delete  from reservation where reservation_id=?");
				pstmt.setInt(1, id);
				i=pstmt.executeUpdate();	
			 p1=conn.setSavepoint();
			 conn.setAutoCommit(true);
		
		} catch (SQLException e) {
				
			e.printStackTrace();
		try {
			conn.rollback(p1);
			return false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		return true;
	}


public  boolean removeReservationDetailById(int id)
	{
	conn=MysqlConnection.getConnection();
	int i=0;
		try {
				pstmt=conn.prepareStatement("delete  from reservation_detail where reservation_id=?");
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
