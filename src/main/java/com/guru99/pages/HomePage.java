package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.guru99.utils.CommonUtils;

public class HomePage {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	CommonUtils common = new CommonUtils();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
