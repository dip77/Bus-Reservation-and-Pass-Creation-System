package com.digimation.gujjubus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.gujjubus.bean.BusDetailBean;
import com.digimation.gujjubus.util.MysqlConnection;

public class BusDetailDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<BusDetailBean> listOfBusDetailBeans;

	public int getBusDetailId(String busNo,int routeId) {
		listOfBusDetailBeans = new ArrayList<BusDetailBean>();
		conn = MysqlConnection.getConnection();
		BusDetailBean busDetailBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select bus_detail_id from bus_detail where route_id=? and bus_no=?");
			pstmt.setInt(1,routeId);
			pstmt.setString(2, busNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				busDetailBeanObj = new BusDetailBean();
			//	busDetailBeanObj.setBusDetailid(rs.getInt("bus_detail_id"));
				//busDetailBeanObj.setBusNo(rs.getString("bus_no"));
				return rs.getInt("bus_detail_id");
				//busDetailBeanObj.setSource(rs.getString("source"));
				//busDetailBeanObj.setDestination(rs.getString("sdestination"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<BusDetailBean> getBusDetailNoList(int id) {
		listOfBusDetailBeans = new ArrayList<BusDetailBean>();
		conn = MysqlConnection.getConnection();
		BusDetailBean busDetailBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select bus_no from bus_detail where route_id=?");
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				busDetailBeanObj = new BusDetailBean();
			//	busDetailBeanObj.setBusDetailid(rs.getInt("bus_detail_id"));
				//busDetailBeanObj.setBusNo(rs.getString("bus_no"));
				busDetailBeanObj.setRouteid(rs.getInt("bus_no"));
				//busDetailBeanObj.setSource(rs.getString("source"));
				//busDetailBeanObj.setDestination(rs.getString("destination"));
				listOfBusDetailBeans.add(busDetailBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfBusDetailBeans;
	}

	public ArrayList<BusDetailBean> getDistinctBusDetailList() {
		listOfBusDetailBeans = new ArrayList<BusDetailBean>();
		conn = MysqlConnection.getConnection();
		BusDetailBean busDetailBeanObj = null;
		try {
			pstmt = conn
					.prepareStatement("select distinct route_id from bus_detail");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				busDetailBeanObj = new BusDetailBean();
			//	busDetailBeanObj.setBusDetailid(rs.getInt("bus_detail_id"));
				//busDetailBeanObj.setBusNo(rs.getString("bus_no"));
				busDetailBeanObj.setRouteid(rs.getInt("route_id"));
				//busDetailBeanObj.setSource(rs.getString("source"));
				//busDetailBeanObj.setDestination(rs.getString("destination"));
				listOfBusDetailBeans.add(busDetailBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfBusDetailBeans;
	}

	public int getRouteId(int sourceId, int destinationId) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("select route_id from route where source_id=? and destination_id=?");
			pstmt.setInt(1, sourceId);
			pstmt.setInt(2, destinationId);

			rs = pstmt.executeQuery();
			rs.next();
			i = rs.getInt("route_id");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return i;

	}

	public boolean addBusDetail(BusDetailBean busDetailBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into bus_detail(bus_no,route_id) values(?,?)");
			pstmt.setString(1, busDetailBeanObj.getBusNo());
			pstmt.setInt(2, busDetailBeanObj.getRouteid());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public BusDetailBean getBusDetailListByPK(Integer busDetailId) {
		conn = MysqlConnection.getConnection();
		BusDetailBean busDetailBeanObj = null;
		try {
			pstmt = conn
					.prepareStatement("select * from bus_detail where bus_detail_id=?");
			pstmt.setInt(1, busDetailId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				busDetailBeanObj = new BusDetailBean();
				busDetailBeanObj.setBusDetailid(busDetailId);
				busDetailBeanObj.setBusNo(rs.getString("bus_no"));
				busDetailBeanObj.setRouteid(rs.getInt("route_id"));
				busDetailBeanObj.setIsAvailable(rs.getString("is_available"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return busDetailBeanObj;
	}

	public ArrayList<BusDetailBean> getBusDetailList() {
		listOfBusDetailBeans = new ArrayList<BusDetailBean>();
		conn = MysqlConnection.getConnection();
		BusDetailBean busDetailBeanObj = null;
		try {
			pstmt = conn
					.prepareStatement("select b.bus_detail_id,b.is_available,r.route_id,"
							+ "bs.bus_no,ss.station_name as source,sd.station_name as destination from bus_detail b,route r"
							+ " ,bus bs,station ss,station sd where b.route_id=r.route_id and r.source_id=ss.station_id "
							+ " and r.destination_id=sd.station_id and  b.bus_no=bs.bus_no");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				busDetailBeanObj = new BusDetailBean();
				busDetailBeanObj.setBusDetailid(rs.getInt("bus_detail_id"));
				busDetailBeanObj.setBusNo(rs.getString("bus_no"));
				busDetailBeanObj.setRouteid(rs.getInt("route_id"));
				busDetailBeanObj.setIsAvailable(rs.getString("is_available"));
				busDetailBeanObj.setSource(rs.getString("source"));
				busDetailBeanObj.setDestination(rs.getString("destination"));
				listOfBusDetailBeans.add(busDetailBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfBusDetailBeans;
	}

	public boolean removeBusDetail(int busDetailId) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("delete  from bus_detail where bus_detail_id=?");
			pstmt.setInt(1, busDetailId);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean updateBusDetail(BusDetailBean busDetailBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update bus_detail set route_id=?,bus_no=?,is_available=?"
							+ " where bus_detail_id=?");
			pstmt.setInt(1, busDetailBeanObj.getRouteid());
			pstmt.setString(2, busDetailBeanObj.getBusNo());
			pstmt.setString(3, busDetailBeanObj.getIsAvailable());
			pstmt.setInt(4, busDetailBeanObj.getBusDetailid());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

}
