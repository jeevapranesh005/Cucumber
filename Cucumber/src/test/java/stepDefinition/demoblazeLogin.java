package stepDefinition;

import java.time.Duration;
import java.util.List;   // ✅ Correct import

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class demoblazeLogin {

    public static WebDriver driver;
    WebDriverWait wait;

    @Given("user is on Homepage")
    public void user_is_on_homepage() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    }

    @When("user enters name and password")
    public void user_enters_name_and_password(DataTable dataTable) {

        List<List<String>> data = dataTable.asLists(String.class);

        String username = data.get(0).get(0);
        String password = data.get(0).get(1);

        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("the error message seen as {string}")
    public void the_error_message_seen_as(String expectedMessage) {

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();

        System.out.println("Alert: " + actualMessage);

        Assert.assertEquals(actualMessage, expectedMessage);

        alert.accept();
        driver.quit();
    }
}