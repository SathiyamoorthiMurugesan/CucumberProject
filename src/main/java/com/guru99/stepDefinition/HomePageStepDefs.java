package com.guru99.stepDefinition;

import com.guru99.base.Base;
import com.guru99.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefs extends Base {
	
	HomePage homePage = new HomePage(driver);
	
	@Given("user launches the guru99 webpage")
	public void user_launches_the_guru99_webpage() {
		homePage.launchApplication();
	}
	
	@Then("validate {string}")
	public void validate(String string) {
		
	}
	
	@When("user enters text\"Java\" on search and clicks on search button")
	public void user_enters_text_java_on_search_and_clicks_on_search_button() {
		
	}

}
