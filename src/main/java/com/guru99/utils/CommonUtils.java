package com.guru99.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.guru99.base.Base;

public class CommonUtils extends Base {
	
	Select select;
	
	public void pause(Integer milliSeconds) {
		try {
			TimeUnit.MICROSECONDS.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void selectFromDropDown(WebElement ele, String text) {
		select = new Select(ele);
		select.selectByVisibleText(text);
	}
}
