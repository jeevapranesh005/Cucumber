package Reports;


//to demonstrate


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReportings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter report=new ExtentHtmlReporter("extentReport.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		WebDriver driver=new ChromeDriver();
		ExtentTest test=extent.createTest("Google search Test");
		try {
			driver.get("nn");
			test.pass("Navigated to google");
			
		}catch(Exception e){
			test.fail("Test failed: "+e.getMessage());
		}finally {
			driver.quit();
			extent.flush();
		}
	}

}
