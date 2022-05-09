package com.guru99.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public static void initiateReport() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		reporter = new ExtentHtmlReporter(
				"C:\\Users\\LENOVO\\eclipse practice workspace\\CucumberProject\\Reports\\MyReport"+dateFormat.format(date)+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	public static void closeReport() {
		extent.flush();
	}

}
