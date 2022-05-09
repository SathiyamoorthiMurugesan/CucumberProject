package com.guru99.base;

import java.sql.ResultSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.guru99.utils.OracleUtil;
import com.guru99.utils.PropertyReader;

public class Base {
	
	public static WebDriver driver;
	
	public WebDriver launchBrowser() throws Exception {
		PropertyReader prop = new PropertyReader();
		String browserName = prop.readAProperty("browse");
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.getProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.getProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("Edge")) {
			System.getProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Error Message ---->" + "browser name not mentioned properly");
		}
		
		return driver;
	}
	
	public static void testQuery(String env) {
		ResultSet rs;
		String value = null;
		try {
			String query = "select columnName from tableName where condition";
			System.out.println("Query to be run "+ query);
			rs = OracleUtil.runDBQuery(query, env);
			while(rs.next()) {
				System.out.println(rs.getObject(1));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
