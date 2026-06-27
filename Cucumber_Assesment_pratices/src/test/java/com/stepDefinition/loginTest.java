package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.loginPages;
import com.utilites.helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginTest {
	
	WebDriver driver;
	WebDriverWait mywait;
	
	
	helper init = new helper();
	HomePage hp ;
	loginPages page ;
	@Given("user is on the home page of tutorial ninja")
	public void user_is_on_the_home_page_of_tutorial_ninja() {
		init.getdriver().get("https://tutorialsninja.com/demo/");
        init.getdriver().manage().window().maximize();

        mywait = new WebDriverWait(
                init.getdriver(),
                Duration.ofSeconds(10));

        page = new loginPages(init.getdriver(), mywait);
        hp = new HomePage(init.getdriver(), mywait);
	}
	
	@When("a user click the myAccount link")
	public void a_user_click_the_my_account_link() {
	   page.clickMyAccount();
	}


	@When("a user click the login link")
	public void a_user_click_the_login_link() {
		page.clickLoginLink();
	}

	@When("a user Enter the E-Mail {string} and password {string}")
	public void a_user_enter_the_e_mail_and_password(String string, String string2) {
		page.email(string);
		page.password(string2);
	   
	}

	@When("a user click the login button")
	public void a_user_click_the_login_button() {
		page.loginButton();
	   
	}

	@Then("user seen the myAccount")
	public void user_seen_the_my_account() {
	    String act = hp.myAccount();
	    String exp ="My Account";
	    Assert.assertEquals(act, exp);
	    System.out.println("LogIn succesfull");
	}

	@When("a user enter the incorrect email {string} and password {string}")
	public void a_user_enter_the_incorrect_email_and_password(String string, String string2) {
		page.email(string);
		page.password(string2);
	}

	@Then("user should seen the error message")
	public void user_should_seen_the_error_message() {
	    String act =page.invalid();
	    String exp ="Warning: No match for E-Mail Address and/or Password.";
	    Assert.assertEquals(act, exp);
	    System.out.println("LogIn not sucessful");
	}



}
