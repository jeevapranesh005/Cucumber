package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {
        "pretty",
        "html:target/cucumber-reports/Cucumber.html",
        "rerun:target/rerun.txt"
    }, // store failed test cases

    features = "@target/rerun.txt", // rerun failed test cases
    glue = "stepDefinition",
    monochrome = true
)

public class Rerun_failed_testcase extends AbstractTestNGCucumberTests {

}