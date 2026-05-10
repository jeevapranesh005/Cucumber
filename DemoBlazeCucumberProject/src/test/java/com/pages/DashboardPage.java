package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver d;
	WebDriverWait wait;
	public DashboardPage(WebDriver d, WebDriverWait wait) {
		super();
		this.d = d;
		this.wait = wait;
	}
	By getUser=By.xpath("//a[text()='Welcome TamilKumar']");
	public String getUsername(){
		wait.until(ExpectedConditions.elementToBeClickable(getUser));
		return d.findElement(getUser).getText();
	}
}
