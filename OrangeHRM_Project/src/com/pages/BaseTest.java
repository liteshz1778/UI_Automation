package com.pages;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Utililies.readPropertiesFile;

public class BaseTest {

	protected static WebDriver driver;

	@BeforeSuite
	@Parameters("browserName")
	public void setup(String browser) throws IOException {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readPropertiesFile.getMyProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readPropertiesFile.getMyProperty("geckoDriverPath"));
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please Enter Correct Browser Name");
			Assert.assertFalse(true);
		}
	}

	@BeforeTest
	public void launchLoginPage() throws IOException {
		driver.get(readPropertiesFile.getMyProperty("testSiteUrl"));
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void endActivity() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();

		System.out.println("Execution Completed");
	}
}
