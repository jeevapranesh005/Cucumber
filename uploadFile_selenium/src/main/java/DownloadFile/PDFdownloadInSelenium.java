package DownloadFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PDFdownloadInSelenium {

    public static void main(String[] args) throws InterruptedException {

        String downloadFilePath = System.getProperty("user.dir")
                + File.separator + "downloads";

        File folder = new File(downloadFilePath);

        if (!folder.exists()) {
            folder.mkdir();
        }

        ChromeOptions opt = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("plugins.always_open_pdf_externally", true);
        prefs.put("download.default_directory", downloadFilePath);

        opt.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(opt);

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/upload-download");

        driver.findElement(By.id("downloadButton")).click();

        Thread.sleep(10000);

        File dir = new File(downloadFilePath);

        File[] files = dir.listFiles();

        if (files != null && files.length > 0) {

            System.out.println("PDF Downloaded Successfully");

            for (File file : files) {
                System.out.println(file.getName());
            }

        } else {
            System.out.println("Download Failed");
        }

        driver.quit();
    }
}