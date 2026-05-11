package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/feature/Login.feature", 
				glue = "stepDefinition", 
				plugin = { "usage", "html:target/cucumber-reports/Cucumber.html"}, 
				monochrome = true)


public class usageReport extends AbstractTestNGCucumberTests {
	
}

