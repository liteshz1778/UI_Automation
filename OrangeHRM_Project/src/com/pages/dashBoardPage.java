package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashBoardPage {

	WebDriver driver;
	@FindBy(xpath = "(//*[text()=\"Dashboard\"])[2]")
	private WebElement dashboard;

	public dashBoardPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement returnDashboard() {
		
		return dashboard;
	}
}
