package com.guru99.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class OracleUtil {
	public static Properties read_dbProperties_file() throws Exception {
		String propFileName = "db.properties";
		InputStream inputStream = OracleUtil.class.getClassLoader().getResourceAsStream(propFileName);
		Properties dbProps = new Properties();
		dbProps.load(inputStream);
		return dbProps;
	}
	
	public static ResultSet runDBQuery(String queryString, String env) throws Exception {
		Properties db = read_dbProperties_file();
		Connection con;
		Statement stmt;
		String url = null, user = null, password = null;
		ResultSet rs = null;
		switch(env) {
		case "Test":
			url = db.getProperty("SIT.DB.URL");
			user = db.getProperty("SIT.DB.USER");
			password = db.getProperty("SIT.DB.PASSWORD");
			break;
		}
		
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println(url + user+ password);
				con = DriverManager.getConnection(url, user, password);
				stmt = con.createStatement();
				rs = stmt.executeQuery(queryString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

}
