package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.OrganizationBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class OrganizationDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<OrganizationBean> listOfOrganizationBeans;
public  boolean addOrganization(OrganizationBean organizationBean)
	{
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into organization(organization,org_address) values(?,?)");
			pstmt.setString(1, organizationBean.getOrganizationName());
			pstmt.setString(2, organizationBean.getOrganizationAddress());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	
	}

public  ArrayList<OrganizationBean> getOrganizationList()
	{
		listOfOrganizationBeans=new ArrayList<OrganizationBean>();
	conn=MysqlConnection.getConnection();
		OrganizationBean organizationBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from organization");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				organizationBeanObj=new OrganizationBean();
				organizationBeanObj.setOrganizationId(rs.getInt("org_id"));
				organizationBeanObj.setOrganizationName(rs.getString("organization"));
			organizationBeanObj.setOrganizationAddress(rs.getString("org_address"));
				listOfOrganizationBeans.add(organizationBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfOrganizationBeans;
	}


public  OrganizationBean getOrganizationListByPK(int id)
	{
	    conn=MysqlConnection.getConnection();
		OrganizationBean organizationBean=null;
		try {
			pstmt=conn.prepareStatement("select * from organization where org_id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				organizationBean=new OrganizationBean();
				organizationBean.setOrganizationId(id);
				organizationBean.setOrganizationName(rs.getString("organization"));
				organizationBean.setOrganizationAddress(rs.getString("org_address"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return organizationBean;
	}

public  boolean updateOrganization(OrganizationBean organizationBean)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update organization set organization=?,org_address=? where org_id=?");
			pstmt.setString(1, organizationBean.getOrganizationName());
			pstmt.setString(2, organizationBean.getOrganizationAddress());
			pstmt.setInt(3, organizationBean.getOrganizationId());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}
public boolean checkReference(int orgId)
{
	int i=0;
	try {
		conn=MysqlConnection.getConnection();
		pstmt=conn.prepareStatement("select * from pass where org_id=?");
		pstmt.setInt(1, orgId);
		 rs=pstmt.executeQuery();
		 if(rs.next())
			 return true;
		
	} catch (SQLException e) {

		e.printStackTrace();
	}
		return false;

}
public  boolean removeOrganization(int id)
{
		int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("delete  from organization where org_id=?");
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
 