package fileUpload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUploadBYSendkeys {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://pdf2doc.com/");

        driver.findElement(By.cssSelector("input[type='file']"))
              .sendKeys("D:\\D-Downloads\\expleo.pdf");

        Thread.sleep(2000);
    }
}