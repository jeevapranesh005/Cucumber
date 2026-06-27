package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPages {

    WebDriver driver;
    WebDriverWait wait;

    public loginPages(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By myaccount = By.xpath("//span[normalize-space()='My Account']");
    By login = By.xpath("//a[normalize-space()='Login']");
    By email = By.id("input-email");
    By password = By.id("input-password");
    By loginButton = By.xpath("//input[@value='Login']");
    By invalid = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    public void clickMyAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myaccount)).click();
    }

    public void clickLoginLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
    }

    public void email(String userEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(userEmail);
    }

    public void password(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    }

    public void loginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }

    public String invalid() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalid)).getText();
    }
}