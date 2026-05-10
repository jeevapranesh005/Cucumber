package com.definitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.actions.DashboardAction;
import com.actions.LoginPageActions;
import com.utilities.HelperClass;
import com.utilities.LoadProperties;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinitions {
	LoginPageActions lpa=new LoginPageActions();
	DashboardAction dpa=new DashboardAction();
	@Given("User on the home page")
	public void user_on_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    HelperClass.openPage();
	}

	@When("User click the login button")
	public void user_click_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    lpa.clickLogin();
	}

	@When("Enter the username and password and click the Login button")
	public void enter_the_username_and_password_and_click_the_login_button() {
	    lpa.Login(LoadProperties.getProp().getProperty("validEmail"),LoadProperties.getProp().getProperty("validPassword"));
	}
	@When("Enter the invalid username and password and click the Login button")
	public void enter_the_invalid_username_and_password_and_click_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		 lpa.Login(LoadProperties.getProp().getProperty("invalidEmail"),LoadProperties.getProp().getProperty("invalidPassword"));
	}
	@Then("User can see the name of the user")
	public void user_can_see_the_name_of_the_user() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals("Welcome TamilKumar", dpa.getName());
	}
	@Then("user can see the user does not exist")
	public void user_can_see_the_user_does_not_exist() {
	    // Write code here that turns the phrase above into concrete actions
		Alert alert = HelperClass.getWait().until(ExpectedConditions.alertIsPresent());

	    Assert.assertEquals("User does not exist.", alert.getText());

	    alert.accept();
	}
	

}
