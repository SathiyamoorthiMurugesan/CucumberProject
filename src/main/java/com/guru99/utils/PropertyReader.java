package com.guru99.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	
	public String readAProperty(String propertyName) throws Exception {
		Properties prop = new Properties();
		String path = System.getProperty("user.dir") + "\\project.properties";
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		return prop.getProperty(propertyName);
	}

}
