package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;


public class TestBase {
	public static WebDriver driver;

	@BeforeSuite
	// the below line is to check the existing browser in the TestNG.xml file
	@Parameters({"browser"})
	//the Optional below, help when we run the project from UserRegistration_Test it will use chrome as default,
	// as we should run the project from TestNG file to find the browsers, if we did not do so, the optional in the below method will be the default
	public void startDriver(@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
 
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot!");
			Helper.captureScreenshot(driver, result.getName());

		}
	}
}
