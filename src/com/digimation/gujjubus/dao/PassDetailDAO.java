package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class PassDetailDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<PassDetailBean> listOfPassDetailBeans;

	public  ArrayList<PassDetailBean> getRegularPassDetailList()
	{
		listOfPassDetailBeans=new ArrayList<PassDetailBean>();
     	conn=MysqlConnection.getConnection();
		PassDetailBean passBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select photo,ps.term_start_date,ps.term_end_date,ps.term_validity," +
					"start_date,end_date,st.station_name as source,sd.station_name as destination," +
					"u.first_name,u.middle_name,u.last_name,u.email," +
					"o.organization,o.org_address,p.pass_id,validity " +
					",amount,term_validity from station st,station sd," +
					"pass ps,pass_detail p,organization o,user u "+
					" where ps.source_id=st.station_id and ps.destination_id=sd.station_id and" +
					" p.pass_id=ps.pass_id and u.user_id=ps.user_id" +
					" and ps.org_id=o.org_id and p.start_date=curdate()");
			 		rs=pstmt.executeQuery();
			 while (rs.next()) {
					passBeanObj=new PassDetailBean();
					passBeanObj.setPhoto(rs.getString("photo"));
					passBeanObj.setTermValidity(rs.getInt("term_validity"));
				 	passBeanObj.setStartTermDate(rs.getString("term_start_date"));
				 	passBeanObj.setEndTermDate(rs.getString("term_end_date"));
					passBeanObj.setStartDate(rs.getString("start_date"));
					passBeanObj.setEndDate(rs.getString("end_date"));
					passBeanObj.setDestination(rs.getString("destination"));
					passBeanObj.setSource(rs.getString("source"));
					passBeanObj.setFirstName(rs.getString("first_name"));
				 	passBeanObj.setMiddleName(rs.getString("middle_name"));
				 	passBeanObj.setLastName(rs.getString("last_name"));
				 	passBeanObj.setEmail(rs.getString("email"));
					passBeanObj.setPassId(rs.getInt("pass_id"));
					passBeanObj.setValidity(rs.getInt("validity")); 
					passBeanObj.setTermValidity(rs.getInt("term_validity"));
					passBeanObj.setTotalAmount(rs.getInt("amount"));
					passBeanObj.setOrganizationAddress(rs.getString("org_address"));
					passBeanObj.setOrganizationName(rs.getString("organization"));
				    listOfPassDetailBeans.add(passBeanObj);
			}
			 
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listOfPassDetailBeans;
	}
	public  PassDetailBean getUniquePassDetail(String startDate,String endDate)
	{
		listOfPassDetailBeans=new ArrayList<PassDetailBean>();
     	conn=MysqlConnection.getConnection();
		PassDetailBean passBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select photo,ps.term_start_date,ps.term_end_date,ps.term_validity," +
					"start_date,end_date,st.station_name as source,sd.station_name as destination," +
					"u.first_name,u.middle_name,u.last_name,u.email," +
					"o.organization,o.org_address,p.pass_id,validity " +
					",amount,term_validity from station st,station sd," +
					"pass ps,pass_detail p,organization o,user u "+
					" where ps.source_id=st.station_id and ps.destination_id=sd.station_id and" +
					" p.pass_id=ps.pass_id and ps.user_id=u.user_id" +
					" and ps.org_id=o.org_id and p.start_date=? and p.end_date=? ");
					pstmt.setString(1, startDate);
					pstmt.setString(2, endDate);
			 		rs=pstmt.executeQuery();
					passBeanObj=new PassDetailBean();
					passBeanObj.setPhoto(rs.getString("photo"));
					passBeanObj.setTermValidity(rs.getInt("term_validity"));
				 	passBeanObj.setStartTermDate(rs.getString("term_start_date"));
				 	passBeanObj.setEndTermDate(rs.getString("term_end_date"));
					passBeanObj.setStartDate(rs.getString("start_date"));
					passBeanObj.setEndDate(rs.getString("end_date"));
					passBeanObj.setDestination(rs.getString("destination"));
					passBeanObj.setSource(rs.getString("source"));
					passBeanObj.setFirstName(rs.getString("first_name"));
				 	passBeanObj.setMiddleName(rs.getString("middle_name"));
				 	passBeanObj.setLastName(rs.getString("last_name"));
				 	passBeanObj.setEmail(rs.getString("email"));
					passBeanObj.setPassId(rs.getInt("pass_id"));
					passBeanObj.setValidity(rs.getInt("validity")); 
					passBeanObj.setTermValidity(rs.getInt("term_validity"));
					passBeanObj.setTotalAmount(rs.getInt("amount"));
					passBeanObj.setOrganizationAddress(rs.getString("org_address"));
					passBeanObj.setOrganizationName(rs.getString("organization"));
				    listOfPassDetailBeans.add(passBeanObj);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return passBeanObj;
	}
	
	public  ArrayList<PassDetailBean> getPassDetailListbyUserId(int userId)
	{
		listOfPassDetailBeans=new ArrayList<PassDetailBean>();
     	conn=MysqlConnection.getConnection();
		PassDetailBean passBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select photo,ps.term_start_date,ps.term_end_date,ps.term_validity," +
					"start_date,end_date,st.station_name as source,sd.station_name as destination," +
					"u.first_name,u.middle_name,u.last_name,u.email," +
					"o.organization,o.org_address,p.pass_id,validity " +
					",amount,term_validity from station st,station sd," +
					"pass ps,pass_detail p,organization o,user u "+
					" where ps.source_id=st.station_id and ps.destination_id=sd.station_id and" +
					" p.pass_id=ps.pass_id and ps.user_id=?" +
					" and ps.org_id=o.org_id ");
					pstmt.setInt(1, userId);
			 		rs=pstmt.executeQuery();
			 while (rs.next()) {
					passBeanObj=new PassDetailBean();
					passBeanObj.setPhoto(rs.getString("photo"));
					passBeanObj.setTermValidity(rs.getInt("term_validity"));
				 	passBeanObj.setStartTermDate(rs.getString("term_start_date"));
				 	passBeanObj.setEndTermDate(rs.getString("term_end_date"));
					passBeanObj.setStartDate(rs.getString("start_date"));
					passBeanObj.setEndDate(rs.getString("end_date"));
					passBeanObj.setDestination(rs.getString("destination"));
					passBeanObj.setSource(rs.getString("source"));
					passBeanObj.setFirstName(rs.getString("first_name"));
				 	passBeanObj.setMiddleName(rs.getString("middle_name"));
				 	passBeanObj.setLastName(rs.getString("last_name"));
				 	passBeanObj.setEmail(rs.getString("email"));
					passBeanObj.setPassId(rs.getInt("pass_id"));
					passBeanObj.setValidity(rs.getInt("validity")); 
					passBeanObj.setTermValidity(rs.getInt("term_validity"));
					passBeanObj.setTotalAmount(rs.getInt("amount"));
					passBeanObj.setOrganizationAddress(rs.getString("org_address"));
					passBeanObj.setOrganizationName(rs.getString("organization"));
				    listOfPassDetailBeans.add(passBeanObj);
			}
			 
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfPassDetailBeans;
	}


public  boolean renewPass(PassDetailBean passDetailBeanObj)
	{
	
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("insert into pass_detail(pass_id,start_date,end_date,amount,validity)" +
					" values(?,"+passDetailBeanObj.getStartDate()+" ,date_add(curdate(),interval "+passDetailBeanObj.getValidity()+
					" day),?,?)");
			pstmt.setInt(1, passDetailBeanObj.getPassId());
			pstmt.setInt(2, passDetailBeanObj.getTotalAmount());
			pstmt.setInt(3, passDetailBeanObj.getValidity());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

	public  ArrayList<PassDetailBean> getPassDetailList(int passId)
	{
		listOfPassDetailBeans=new ArrayList<PassDetailBean>();
     	conn=MysqlConnection.getConnection();
		PassDetailBean passBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select photo,ps.term_start_date,ps.term_end_date,ps.term_validity," +
					"start_date,end_date,st.station_name as source,sd.station_name as destination," +
					"u.first_name,u.middle_name,u.last_name,u.email," +
					"o.organization,o.org_address,p.pass_id,validity " +
					",amount,term_validity from station st,station sd," +
					"pass ps,pass_detail p,organization o,user u "+
					" where ps.source_id=st.station_id and ps.destination_id=sd.station_id and" +
					" p.pass_id=ps.pass_id and u.user_id=ps.user_id" +
					" and ps.org_id=o.org_id and p.pass_id="+passId);
			 		rs=pstmt.executeQuery();
			 while (rs.next()) {
					passBeanObj=new PassDetailBean();
					passBeanObj.setPhoto(rs.getString("photo"));
					passBeanObj.setTermValidity(rs.getInt("term_validity"));
				 	passBeanObj.setStartTermDate(rs.getString("term_start_date"));
				 	passBeanObj.setEndTermDate(rs.getString("term_end_date"));
					passBeanObj.setStartDate(rs.getString("start_date"));
					passBeanObj.setEndDate(rs.getString("end_date"));
					passBeanObj.setDestination(rs.getString("destination"));
					passBeanObj.setSource(rs.getString("source"));
					passBeanObj.setFirstName(rs.getString("first_name"));
				 	passBeanObj.setMiddleName(rs.getString("middle_name"));
				 	passBeanObj.setLastName(rs.getString("last_name"));
				 	passBeanObj.setEmail(rs.getString("email"));
					passBeanObj.setPassId(rs.getInt("pass_id"));
					passBeanObj.setValidity(rs.getInt("validity")); 
					passBeanObj.setTermValidity(rs.getInt("term_validity"));
					passBeanObj.setTotalAmount(rs.getInt("amount"));
					passBeanObj.setOrganizationAddress(rs.getString("org_address"));
					passBeanObj.setOrganizationName(rs.getString("organization"));
				    listOfPassDetailBeans.add(passBeanObj);
			}
			 
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfPassDetailBeans;
	}


	public  PassDetailBean getPassDetailListByPK(int passDetailId)
	{
	    conn=MysqlConnection.getConnection();
		PassDetailBean passDetailBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from pass_detail where pass_id=?");
			pstmt.setInt(1, passDetailId);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				passDetailBeanObj=new PassDetailBean();
				passDetailBeanObj.setPassDetailId(passDetailId);
				passDetailBeanObj.setValidity(rs.getInt("validity"));
				passDetailBeanObj.setTermValidity(rs.getInt("term_validity"));
				
				
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return passDetailBeanObj;
	}

public  boolean removePassDetail(int id)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("delete  from pass_detail where pass_detail_id=?");
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

public  boolean updatePass(PassDetailBean passDetailBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update pass_detail set validity=?,term_validity=?,amount=?" +
					" where pass_detail_id=?");
			pstmt.setInt(1, passDetailBeanObj.getValidity());
			pstmt.setInt(2, passDetailBeanObj.getTermValidity());
			pstmt.setInt(3, passDetailBeanObj.getTotalAmount());
			pstmt.setInt(4, passDetailBeanObj.getPassDetailId());
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
