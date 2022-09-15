package com.guru99.pages;

import java.time.Duration;

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
	
	public void launchApplication() {
		driver.manage().window().maximize();
		driver.get("https://www.guru99.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}

}
