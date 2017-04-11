package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.AdminBean;
import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.util.MysqlConnection;
import com.digimation.gujjubus.util.ValidateUtils;

public class UserDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<UserBean> listOfUserBeans;

public  ArrayList<UserBean> getRegularUserList()
	{
		listOfUserBeans=new ArrayList<UserBean>();
	conn=MysqlConnection.getConnection();	
		UserBean userBeanObj=null;
		try {	
				pstmt=conn.prepareStatement("select * from user,city "+
					"where user.city_id=city.city_id and reg_date=curdate()");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				 userBeanObj=new UserBean();
					userBeanObj.setUserId(rs.getInt("user_id"));
					userBeanObj.setFirstName(rs.getString("first_name"));
					userBeanObj.setMiddleName(rs.getString("middle_name"));
					userBeanObj.setLastName(rs.getString("last_name"));
				    userBeanObj.setMobile(rs.getString("mobile_no"));
				    userBeanObj.setEmail(rs.getString("email"));
				    userBeanObj.setAddress(rs.getString("address"));
				    userBeanObj.setGender(rs.getString("gender"));
				    userBeanObj.setCity(rs.getString("city_name"));
				    userBeanObj.setCityId(rs.getInt("city_id"));
				    userBeanObj.setIsActive(rs.getString("is_active"));
				    listOfUserBeans.add(userBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfUserBeans;
	}

public  boolean resetPassword(UserBean userBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update user set password=? where email=?");
			pstmt.setString(1, userBeanObj.getPassword());
			pstmt.setString(2, userBeanObj.getEmail());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}


public  boolean changePassword(UserBean userBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update user set password=? where user_id=?");
			pstmt.setString(1, userBeanObj.getPassword());
			pstmt.setInt(2, userBeanObj.getUserId());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}

	public Object checkUser(String userName,String password)
	{
		UserBean userBeanObj=null;
		AdminBean adminBeanObj=null;
		try {
			
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from user where email=?");
			pstmt.setString(1, userName);
			rs=pstmt.executeQuery();
			 if(rs.next() && ValidateUtils.base64decode(rs.getString("password")).equals(password) )
			 {
				 userBeanObj=new UserBean();
					  userBeanObj.setPassword(ValidateUtils.base64decode(rs.getString("password")));
					 userBeanObj.setUserId(rs.getInt("user_id"));
					userBeanObj.setFirstName(rs.getString("first_name"));
					userBeanObj.setMiddleName(rs.getString("middle_name"));
					userBeanObj.setLastName(rs.getString("last_name"));
				    userBeanObj.setMobile(rs.getString("mobile_no"));
				    userBeanObj.setEmail(rs.getString("email"));
				    userBeanObj.setAddress(rs.getString("address"));
				    userBeanObj.setGender(rs.getString("gender"));
				    userBeanObj.setCityId(rs.getInt("city_id"));
				  
				    userBeanObj.setIsActive(rs.getString("is_active"));
				    return userBeanObj;
			 }
			 else
			 {	 
				 pstmt=conn.prepareStatement("select * from admin where email=?");
				 pstmt.setString(1, userName);
				rs=pstmt.executeQuery();
				 if(rs.next() && ValidateUtils.base64decode(rs.getString("password")).equals(password)){
					
					 	adminBeanObj=new AdminBean();
						adminBeanObj.setAdminId(rs.getInt("admin_id"));
						adminBeanObj.setFirstName(rs.getString("first_name"));
						adminBeanObj.setMiddleName(rs.getString("middle_name"));
						adminBeanObj.setLastName(rs.getString("last_name"));
					    adminBeanObj.setEmail(rs.getString("email"));
					    adminBeanObj.setGender(rs.getString("gender"));
					    adminBeanObj.setCityId(rs.getInt("city_id"));
					    adminBeanObj.setPassword(rs.getString("password"));
					    adminBeanObj.setIsActive(rs.getString("is_active"));
					    return adminBeanObj;
				 }
				 
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return null;

	}


	public boolean checkReference(int cityId)
	{
		try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from pass where user_id=?");
			pstmt.setInt(1, cityId);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;
				pstmt=conn.prepareStatement("select * from reservation where user_id=?");
				pstmt.setInt(1, cityId);
				rs=pstmt.executeQuery();
				 if(rs.next())
					 return true;		 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}

	
public boolean isEmailExists(String email)
{
	   conn=MysqlConnection.getConnection();
			try {
				pstmt=conn.prepareStatement("select * from user where email=?");
				pstmt.setString(1, email);
				rs=pstmt.executeQuery();
				 if (rs.next()) {
			return true;
				 }
			} catch (SQLException e) {

				e.printStackTrace();
			}

			return false;
}
	public  boolean addUser(UserBean userBeanObj) {
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into user(first_name,middle_name,last_name," +
					"password,email,gender,address,city_id,mobile_no,reg_date) values(?,?,?,?,?,?,?,?,?" +
					",curdate())");
			pstmt.setString(1, userBeanObj.getFirstName());
			pstmt.setString(2, userBeanObj.getMiddleName());
			pstmt.setString(3, userBeanObj.getLastName());
			pstmt.setString(4, userBeanObj.getPassword());
			pstmt.setString(5, userBeanObj.getEmail());
			pstmt.setString(6, userBeanObj.getGender());
			pstmt.setString(7, userBeanObj.getAddress());
			pstmt.setInt(8, userBeanObj.getCityId());
			pstmt.setString(9, userBeanObj.getMobile());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	

		
	}

	public  UserBean getUserListByPK(int userId)
	{
	    conn=MysqlConnection.getConnection();
		UserBean userBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from user where user_id=?");
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				userBeanObj=new UserBean();
				userBeanObj.setUserId(userId);
				userBeanObj.setFirstName(rs.getString("first_name"));
				userBeanObj.setMiddleName(rs.getString("middle_name"));
				userBeanObj.setLastName(rs.getString("last_name"));
			    userBeanObj.setMobile(rs.getString("mobile_no"));
			    userBeanObj.setEmail(rs.getString("email"));
			    userBeanObj.setAddress(rs.getString("address"));
			    userBeanObj.setGender(rs.getString("gender"));
			    userBeanObj.setCityId(rs.getInt("city_id"));
			    userBeanObj.setPassword(rs.getString("password"));
			    userBeanObj.setIsActive(rs.getString("is_active"));
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return userBeanObj;
	}


public  boolean updateUser(UserBean userBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update user set first_name=?,middle_name=?,last_name=?,is_active=?," +
					"city_id=?,email=?,mobile_no=?,address=?,gender=?"
					+" where user_id=?");

			pstmt.setString(1, userBeanObj.getFirstName());
			pstmt.setString(2, userBeanObj.getMiddleName());
			pstmt.setString(3, userBeanObj.getLastName());
			pstmt.setString(6, userBeanObj.getEmail());
			pstmt.setString(4, userBeanObj.getIsActive());
			pstmt.setString(9, userBeanObj.getGender());
			pstmt.setString(8, userBeanObj.getAddress());
			pstmt.setInt(5, userBeanObj.getCityId());
			pstmt.setString(7, userBeanObj.getMobile());
			pstmt.setInt(10, userBeanObj.getUserId());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}



public  boolean removeUser(int userId)
{
conn=MysqlConnection.getConnection();
	int i=0;
	try {
		pstmt=conn.prepareStatement("delete  from user where user_id=?");
		pstmt.setInt(1, userId);
		 i=pstmt.executeUpdate();
	} catch (SQLException e) {

		e.printStackTrace();
	}
	if(i==0)
		return false;
else 
	return true;
}




public  ArrayList<UserBean> getUserList()
	{
		listOfUserBeans=new ArrayList<UserBean>();
	conn=MysqlConnection.getConnection();	
		UserBean userBeanObj=null;
		try {	
				pstmt=conn.prepareStatement("select * from user,city "+
					"where user.city_id=city.city_id");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				 userBeanObj=new UserBean();
					userBeanObj.setUserId(rs.getInt("user_id"));
					userBeanObj.setFirstName(rs.getString("first_name"));
					userBeanObj.setMiddleName(rs.getString("middle_name"));
					userBeanObj.setLastName(rs.getString("last_name"));
				    userBeanObj.setMobile(rs.getString("mobile_no"));
				    userBeanObj.setEmail(rs.getString("email"));
				    userBeanObj.setAddress(rs.getString("address"));
				    userBeanObj.setGender(rs.getString("gender"));
				    userBeanObj.setCity(rs.getString("city_name"));
				    userBeanObj.setCityId(rs.getInt("city_id"));
				    userBeanObj.setIsActive(rs.getString("is_active"));
				    listOfUserBeans.add(userBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfUserBeans;
	}


}
