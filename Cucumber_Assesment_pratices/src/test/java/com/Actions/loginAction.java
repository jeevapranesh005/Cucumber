package com.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.loginPages;

public class loginAction {
	WebDriver driver;
	WebDriverWait mywait;
	loginPages page = new loginPages(driver, mywait);
	
	public void clickMyAccount(String username,String password) {
		page.clickMyAccount();
		page.clickLoginLink();
		page.email(username);
		page.password(password);
		page.loginButton();
	}

}
