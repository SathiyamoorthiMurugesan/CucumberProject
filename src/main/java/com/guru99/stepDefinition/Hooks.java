package com.guru99.stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.guru99.base.Base;

import io.cucumber.java.*;

public class Hooks extends Base {
	
	Base base;

	@Before
	public void initializeTest() throws Exception {
		base = new Base();
		base.launchBrowser();
	}
	
	@After
	public void closeBrowser() {
		base.quitBrowser();
	}
	
//	@AfterStep
//	public void addScreenshot(Scenario scenario){
//
//	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//	      scenario.attach(screenshot, "image/png", "image"); 
//		
//	}
	
//	Take screenshots only for failed scenario
	@AfterStep
	public void addScreenshotForFailedScenario(Scenario scenario){

		
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image"); 
		}
		
	}

}
