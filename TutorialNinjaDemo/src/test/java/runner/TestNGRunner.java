package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty",
		"html:target/cucucmber-reports/Cucumber.html" }, features = "src/test/resources/Features", glue = "StepDefinitions")

public class TestNGRunner extends AbstractTestNGCucumberTests {

}
