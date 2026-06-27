// hooks.java
package com.stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utilites.helper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

    helper init = new helper();

    // Before each scenario
    @Before
    public void setup() {

        init.setup();
    }

    // After each scenario
    @After
    public void end(Scenario scenario) {

        // Screenshot only for failed scenarios
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) helper.getdriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        init.end();
    }
}