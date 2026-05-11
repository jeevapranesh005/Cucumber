package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/Login.feature", 
				glue = "com.definitions", 
				plugin = { "usage"}, 
				monochrome = true)


public class usageReport extends AbstractTestNGCucumberTests {
	
}

