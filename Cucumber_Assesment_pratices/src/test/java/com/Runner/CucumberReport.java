package com.Runner;
//runner
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = { "src\\test\\resources\\com.Features\\login.feature" }, glue = {
		"com.stepDefinition" }, plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class CucumberReport extends AbstractTestNGCucumberTests {

}