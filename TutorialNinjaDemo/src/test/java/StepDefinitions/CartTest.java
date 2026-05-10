package StepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartTest {
	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void teardown() {
		if (driver != null)
			driver.quit();
	}

	@Given("user is on the Account page")
	public void user_is_on_the_account_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://tutorialsninja.com/demo/");
	}

	@When("user click the product")
	public void user_click_the_product(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : user) {
			driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(form.get("itemNameSearch"),
					Keys.ENTER);
			driver.findElement(By.linkText(form.get("itemNameCart"))).click();
			driver.findElement(By.xpath("//button[@id='button-cart']")).click();

		}
	}

	@Then("user verifies the items in the cart")
	public void user_verifies_the_items_in_the_cart(io.cucumber.datatable.DataTable dataTable) {

		driver.findElement(By.xpath("//span[normalize-space()='Shopping Cart']")).click();
		List<Map<String, String>> cartProducts = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : cartProducts) {
			String expectedProduct = form.get("cartProduct");
			String actualProduct = driver.findElement(By.linkText(expectedProduct)).getText();
			Assert.assertEquals(actualProduct, expectedProduct);
			
		}
		System.out.println("All Products Verified Successfully");
	}
}
