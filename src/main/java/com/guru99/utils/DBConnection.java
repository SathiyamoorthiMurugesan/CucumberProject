package com.guru99.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
	static Connection conn = null;
	static Properties properties;
	static String url;
	static String userName;
	static String password;
	static String driver;
	static String propFileName = "db.properties";
	
	public static Connection getDatabaseConnection() throws Exception {
		if(conn != null) 
			return conn;
		
		Properties properties;
		InputStream inputStream;
		
		properties = new Properties();
		inputStream = ClassLoader.getSystemResourceAsStream(propFileName);
		if(inputStream != null) {
			properties.load(inputStream);
		}
		else {
			throw new FileNotFoundException("Property File " + propFileName + " not found in class path");
		}
		
		url = properties.getProperty("url");
		System.out.println(url);
		userName = properties.getProperty(userName);
		password = properties.getProperty(password);
		
		System.out.println("Database connection Established");
		return getDBConnection(url, userName, password);
	}
	
	public static Connection getDBConnection(String url, String userName, String password) throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Opening Database Connection");
			conn = DriverManager.getConnection(url, userName, password);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
