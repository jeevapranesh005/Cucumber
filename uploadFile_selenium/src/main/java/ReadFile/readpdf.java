package ReadFile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class readpdf {

    public static void main(String[] args) throws IOException {

        String down_path = System.getProperty("user.dir")
                + File.separator + "downloads";

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        // Force PDF download
        prefs.put("plugins.always_open_pdf_externally", true);

        // Download location
        prefs.put("download.default_directory", down_path);

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/FileDownload.html");

        WebElement downLink = driver.findElement(
                By.xpath("//div[@style='text-align: center;']/a[text()='Download']"));

        downLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        File downloadedFile = new File(
                down_path + File.separator + "samplefile.pdf");

        // Explicit wait until file downloaded
        wait.until((ExpectedCondition<Boolean>) wd -> downloadedFile.exists());

        if (downloadedFile.exists()) {

            System.out.println("PDF Downloaded Successfully");

            // Read PDF using PDFBox
            PDDocument document = Loader.loadPDF(downloadedFile);

            PDFTextStripper pdfStripper = new PDFTextStripper();

            String text = pdfStripper.getText(document);

            System.out.println("Text inside PDF:");
            System.out.println(text);

            document.close();

        } else {

            System.out.println("PDF Download Failed");
        }

        driver.quit();
    }
}