package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.OrganizationBean;
import com.digimation.gujjubus.bean.PassBean;
import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class PassDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<PassBean> listOfPassBeans;

	public int getPassID(int userId)
	{
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("select pass_id from pass where user_id=?");
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				return rs.getInt("pass_id");
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	public boolean isExists(int userId)
	{
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("select * from pass where user_id=?");
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				 return true;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
	public  boolean addPass(PassBean passBeanObj,PassDetailBean passDetailBean,OrganizationBean organizationBean) {
		conn=MysqlConnection.getConnection();
		Savepoint p1 = null;
		String sql;
		int i=0;
		try {
			p1=conn.setSavepoint("p1");
			conn.setAutoCommit(false);
			if(organizationBean!=null){
				pstmt=conn.prepareStatement("insert into organization(organization,org_address) values(?,?)");
				pstmt.setString(1, organizationBean.getOrganizationName());
				pstmt.setString(2, organizationBean.getOrganizationAddress());
			sql="insert into pass(user_id,pass_type_id,source_id," +
					"destination_id,term_validity,term_start_date,term_end_date,org_id,photo)" +
					" values(?,?,?,?,?,curdate(),date_add(curdate(),interval "+passBeanObj.getTermValidity()+
					" day),LAST_INSERT_ID(),?)";
			i=pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(6,passBeanObj.getPhoto());
			}
			else
			{
				sql="insert into pass(user_id,pass_type_id,source_id," +
						"destination_id,term_validity,term_start_date,term_end_date,org_id,photo)" +
						" values(?,?,?,?,?,curdate(),date_add(curdate(),interval "+passBeanObj.getTermValidity()+
					" day),?,?)";
				pstmt=conn.prepareStatement(sql);	
				pstmt.setInt(6, passBeanObj.getOrgId());
				pstmt.setString(7, passBeanObj.getPhoto());
				
			}
				p1=conn.setSavepoint("p1");			
			pstmt.setInt(1, passBeanObj.getUserId());
			pstmt.setInt(2, passBeanObj.getPassTypeId());
			pstmt.setInt(3, passBeanObj.getSourceId());
			pstmt.setInt(4, passBeanObj.getDestinationId());
			pstmt.setInt(5, passBeanObj.getTermValidity());
		System.out.println(sql);
			i=pstmt.executeUpdate();
			 p1=conn.setSavepoint("p1");
			 pstmt=conn.prepareStatement("insert into pass_detail(pass_id,validity,amount,start_date" +
						",end_date) values(LAST_INSERT_ID(),?,?,"+passDetailBean.getStartDate()+
						","+"DATE_ADD("+passDetailBean.getStartDate()+",INTERVAL "+ passDetailBean.getValidity()+" DAY))"); 
			
			 pstmt.setInt(1, passDetailBean.getValidity());
			pstmt.setInt(2, passDetailBean.getTotalAmount());
			i=pstmt.executeUpdate();
			 p1=conn.setSavepoint("p1");
			 conn.commit();		
		} catch (SQLException e) {
			
e.printStackTrace();

try {
	conn.rollback(p1);
} catch (SQLException e1) {
	e1.printStackTrace();
	return false;	
}

		}
				return true;	
	
	
	}

public  ArrayList<PassBean> getPassList()
	{
		listOfPassBeans=new ArrayList<PassBean>();
     	conn=MysqlConnection.getConnection();
		PassBean passBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select o.organization,p.term_validity,p.term_start_date,p.term_end_date," +
					"u.user_id,u.first_name,u.middle_name,u.last_name,u.email,pass_id,ss.station_name as source,sd.station_name " +
					"as destination,pass_type,p.is_active from pass p,user u,station "+
					"ss,pass_type pt,station sd,organization o where p.user_id=u.user_id and "+
					"p.source_id=ss.station_id and p.destination_id=sd.station_id"+
					" and p.pass_type_id=pt.pass_type_id and o.org_id=p.org_id");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				 	passBeanObj=new PassBean();
				 	passBeanObj.setOrgName(rs.getString("organization"));
				 	passBeanObj.setFirstName(rs.getString("first_name"));
				 	passBeanObj.setMiddleName(rs.getString("middle_name"));
				 	passBeanObj.setLastName(rs.getString("last_name"));
				 	passBeanObj.setEmail(rs.getString("email"));
				 	passBeanObj.setPassId(rs.getInt("pass_id"));
					passBeanObj.setIsActive(rs.getString("is_active"));
					passBeanObj.setSource(rs.getString("source")); 	 	
					passBeanObj.setDestination(rs.getString("destination"));
				    passBeanObj.setPassType(rs.getString("pass_type"));
				    passBeanObj.setUserId(rs.getInt("user_id"));
				    passBeanObj.setTermValidity(rs.getInt("term_validity"));
				    listOfPassBeans.add(passBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfPassBeans;
	}



	public  PassBean getPassListByPK(int passId)
	{
	    conn=MysqlConnection.getConnection();
		PassBean passBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from pass where pass_id=?");
			pstmt.setInt(1, passId);
			rs=pstmt.executeQuery();
			 if (rs.next()) {	
				passBeanObj=new PassBean();
				passBeanObj.setPassId(passId);
				passBeanObj.setIsActive(rs.getString("is_active"));
				passBeanObj.setSourceId(rs.getInt("source_id"));
				passBeanObj.setDestinationId(rs.getInt("destination_id"));
			    passBeanObj.setPassTypeId(rs.getInt("pass_type_id"));
			    passBeanObj.setUserId(rs.getInt("user_id"));
			    passBeanObj.setOrgId(rs.getInt("org_id"));
			    passBeanObj.setPhoto(rs.getString("photo"));
			    passBeanObj.setTermValidity(rs.getInt("term_validity"));
			    passBeanObj.setStartTermDate(rs.getString("term_start_date"));
			    passBeanObj.setEndTermDate(rs.getString("term_end_date"));
			    passBeanObj.setSource(new StationDAO().getStationListByPK(passBeanObj.getSourceId()).getStationName());
			    passBeanObj.setDestination(new StationDAO().getStationListByPK(passBeanObj.getDestinationId()).getStationName());
			    
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return passBeanObj;
	}

	

public  boolean updatePass(PassBean passBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update pass set source_id=?,destination_id=?,pass_type_id=?," +
	"is_active=?,user_id=?,term_validity=? where pass_id=?");
			pstmt.setInt(1, passBeanObj.getSourceId());
			pstmt.setInt(2, passBeanObj.getDestinationId());
			pstmt.setInt(3, passBeanObj.getPassTypeId());
			pstmt.setString(4, passBeanObj.getIsActive());
			pstmt.setInt(5,passBeanObj.getUserId());
			pstmt.setInt(7,passBeanObj.getPassId());
			pstmt.setInt(6, passBeanObj.getTermValidity());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

public  boolean removePass(int passId)
{
	Savepoint p1 = null;
conn=MysqlConnection.getConnection();
	
int i=0;
	try {
	conn.setAutoCommit(false);
	
	p1=conn.setSavepoint();
	pstmt=conn.prepareStatement("delete from pass_detail where pass_id=?");
	pstmt.setInt(1, passId);
	 i=pstmt.executeUpdate();
	 p1=conn.setSavepoint();
	 pstmt=conn.prepareStatement("delete  from pass where pass_id=?");
		pstmt.setInt(1, passId);
		 i=pstmt.executeUpdate();
	} catch (SQLException e) {
		try {	
			conn.rollback(p1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();
	}
try {
	conn.commit();

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
return false;
}
return true;
}


}
