package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.digimation.gujjubus.bean.CityBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class CityDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<CityBean> listOfCityBeans;

	public boolean checkReference(int cityId)
	{
		try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from user where city_id=?");
			pstmt.setInt(1, cityId);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;
			 pstmt=conn.prepareStatement("select * from admin where city_id=?");
				pstmt.setInt(1, cityId);
				 rs=pstmt.executeQuery();
				 if(rs.next())
					 return true;
				 
				pstmt=conn.prepareStatement("select * from bus where bus_depo_id=?");
				pstmt.setInt(1, cityId);
				rs=pstmt.executeQuery();
				 if(rs.next())
					 return true;
					pstmt=conn.prepareStatement("select * from station where city_id=?");
					pstmt.setInt(1, cityId);
					 rs=pstmt.executeQuery();
					 if(rs.next())
						 return true;
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}

	
	public boolean addCity(CityBean cityBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into city(city_name) values(?)");
			pstmt.setString(1, cityBeanObj.getCityName());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<CityBean> getCityList() {
		listOfCityBeans = new ArrayList<CityBean>();
		conn = MysqlConnection.getConnection();
		CityBean cityBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from city");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cityBeanObj = new CityBean();
				cityBeanObj.setCityId(rs.getInt("city_id"));
				cityBeanObj.setCityName(rs.getString("city_name"));
				listOfCityBeans.add(cityBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfCityBeans;
	}

	public CityBean getCityListByPK(int id) {
		conn = MysqlConnection.getConnection();
		CityBean cityBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from city where city_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cityBeanObj = new CityBean();
				cityBeanObj.setCityId(id);
				cityBeanObj.setCityName(rs.getString("city_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityBeanObj;
	}

	public boolean updateCity(CityBean cityBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update city set city_name=? where city_id=?");
			pstmt.setString(1, cityBeanObj.getCityName());
			pstmt.setInt(3, cityBeanObj.getCityId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeCity(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from city where city_id=?");
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}
public static void main(String[] args) {
	 ArrayList<CityBean> list = new CityDAO().getCityList();
 System.out.println(list.size());
}
}
