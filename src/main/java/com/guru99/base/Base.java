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
		String browserName = prop.readAProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse practice workspace\\CucumberProject\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Error Message ---->" + "browser name not mentioned properly");
		}
		
		return driver;
	}
	
	public void quitBrowser() {
		driver.quit();
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
