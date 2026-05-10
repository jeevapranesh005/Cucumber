package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {
	WebDriver driver;
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
	@Given("user on the homepage")
	public void user_on_the_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/logout");
	}
	@When("user navigates to Register page")
	public void user_navigates_to_register_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
	}

	@When("user enters registration details")
	public void user_enters_registration_details(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    List<List<String>>RegisterForm=dataTable.asLists();
	    driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(RegisterForm.get(0).get(0));
	    driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(RegisterForm.get(0).get(1));
	    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(RegisterForm.get(0).get(2));
	    driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(RegisterForm.get(0).get(3));
	    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(RegisterForm.get(0).get(4));
	    driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(RegisterForm.get(0).get(5));
	
	}

	@When("accept terms")
	public void accept_terms() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//input[@name='agree']")).click();
	}

	@When("click Continue")
	public void click_continue() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("user should see {string}")
	public void user_should_see(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(string,driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText());
	}



}
