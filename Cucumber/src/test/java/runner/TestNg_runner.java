package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html",
    		"rerun:target/rerun.txt","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, // create a txt for store the failed test cases
    features = "src/test/resources/feature/login.feature",
    glue = "stepDefinition"
   
)
public class TestNg_runner extends AbstractTestNGCucumberTests {

}