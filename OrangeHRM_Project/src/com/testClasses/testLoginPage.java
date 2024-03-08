package com.testClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pages.BaseTest;
import com.pages.LoginPage;
import com.pages.dashBoardPage;

import Utililies.excelReader;

@Listeners(Utililies.TestListenersClass.class)
public class testLoginPage extends BaseTest {


	@Test(priority = 1)
	public void testcase1() throws InterruptedException, IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		int i = 0;
		int j = 0;
		LoginPage lp = new LoginPage(driver);
		lp.sendUsernamePasswd(excelReader.readData(i,j), excelReader.readData(i,++j));
		Thread.sleep(3000);
		lp.submitButton();
		
		dashBoardPage dbp = new dashBoardPage(driver);
		
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		fwait.until(ExpectedConditions.textToBePresentInElement(dbp.returnDashboard(), "Dashboard"));
		
		Assert.assertEquals(dbp.returnDashboard().getText(), "Dashboard");
	}
}
