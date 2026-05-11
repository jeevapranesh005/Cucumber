package fileUpload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoITdemo {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://pdf2doc.com/");

        driver.findElement(By.xpath("//span[normalize-space()='UPLOAD FILES']")).click();

        Thread.sleep(2000);

        Runtime.getRuntime().exec("C:\\Users\\jeeva\\OneDrive\\Desktop\\EXPLEO\\AutoIT\\pdfUpload.exe");

    }
}