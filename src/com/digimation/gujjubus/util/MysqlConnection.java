package com.digimation.gujjubus.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;


public class MysqlConnection {

	private static final String username="username";
	private static final String password="password";
	private static  final String url="url";
	private static String driverClass="com.mysql.jdbc.Driver";
	public static Connection getConnection(){
		Connection conn=null;
		try {
				Class.forName(driverClass);
				conn= DriverManager.getConnection(getProperty(url), getProperty(username), getProperty(password));
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

	private static String getProperty(String propertyName)
	{
				Properties properties = new Properties();
				InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/sql.properties");
		try {
			properties.load(inStream);
		} catch (IOException e) {
			System.out.println(String.format("Exception Occured while fecthing properties: {}",e.getMessage()));
		}
		return Optional.ofNullable((String)properties.get(propertyName)).orElse("");
	}
	
	
	
	
}
