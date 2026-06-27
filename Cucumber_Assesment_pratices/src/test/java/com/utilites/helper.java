// helper.java
package com.utilites;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helper {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriverWait wait;

    // Browser setup
    public void setup() {

        driver.set(new ChromeDriver());

        getdriver().manage().window().maximize();

        getdriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));

    }

    // Get current thread driver
    public static WebDriver getdriver() {

        return driver.get();
    }

    // Close browser
    public void end() {

        if (getdriver() != null) {

            getdriver().quit();

            driver.remove();
        }
    }
}