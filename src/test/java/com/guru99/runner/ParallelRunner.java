package com.guru99.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\parellel"
		,glue = {"com.guru99.parallelStepDefs"}
//		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//		,monochrome = true
		
		)
public class ParallelRunner {

}
