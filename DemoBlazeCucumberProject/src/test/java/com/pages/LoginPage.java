package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver d;
	WebDriverWait wait;
	public LoginPage(WebDriver d,WebDriverWait wait) {
		this.wait=wait;
		this.d = d;
	}
	 By loginBtn=By.xpath("//a[@id='login2']");
	 By username=By.xpath("//input[@id='loginusername']");
	 By password=By.xpath("//input[@id='loginpassword']");
	 By login=By.xpath("//button[text()=\"Log in\"]");
	public void clickLogin(){
		d.findElement(loginBtn).click();
	}
	public void sendUsername(String user){
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		d.findElement(username).sendKeys(user);
	}
	public void sendPassword(String pass){
		d.findElement(password).sendKeys(pass);
	}
	public void submit(){
		d.findElement(login).click();
	}
	
}
