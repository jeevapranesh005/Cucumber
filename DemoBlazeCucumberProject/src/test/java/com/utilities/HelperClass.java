package com.utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	private static ThreadLocal<WebDriverWait> wait=new ThreadLocal<WebDriverWait>();
	private static Logger log=LogManager.getLogger();
	public static void setup() {
		WebDriver driver1=new ChromeDriver();
		driver.set(driver1);
		driver1.manage().window().maximize();
        wait.set(new WebDriverWait(driver1, Duration.ofSeconds(10)));
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static WebDriverWait getWait() {
		return wait.get();
	}
	public static void tearDown() {
		if(getDriver()!=null)
			getDriver().quit(); 
	}
	public static void openPage() {
		log.info("URl is launched");
        getDriver().get("https://www.demoblaze.com/");
    }
}
