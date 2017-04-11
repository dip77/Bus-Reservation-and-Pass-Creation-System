package com.digimation.gujjubus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

	private static String username="root";
	private static  String password="123";
	private static  String URL="jdbc:mysql://localhost:3306/busindicator";
	private static String driverClass="com.mysql.jdbc.Driver";
	public static Connection getConnection(){
		Connection conn=null;
		try {
				Class.forName(driverClass);
				conn= DriverManager.getConnection(URL, username, password);
		if(conn==null)
			System.out.println("not connected");
		else
			System.out.println("connected");
		} catch (ClassNotFoundException e)  {
			e.printStackTrace();
		} 
		catch ( SQLException e){
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	
	
}
