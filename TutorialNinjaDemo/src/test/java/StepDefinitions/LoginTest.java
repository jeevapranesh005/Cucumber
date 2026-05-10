package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	WebDriver driver;
	@Given("user on the home page")
	public void user_on_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/logout");
	}

	@Given("click login Button")
	public void click_login_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
	}

	@When("User enters the {string}")
	public void user_enters_the(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(string);
	}

	@When("user enters the {string} and click the Login Button")
	public void user_enters_the_and_click_the_login_button(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(string);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("user should show the logout button {string}")
	public void user_should_show_the_logout_button(String string) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(string, driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).getText());
	}

	@Then("user should show the error message {string}")
	public void user_should_show_the_error_message(String string) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(string,driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());
	}
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void teardown() {
		if(driver!=null)
			driver.quit();
	}

}
