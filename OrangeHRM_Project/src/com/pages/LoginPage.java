package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//*[@name=\"username\"]")
	private WebElement username;

	@FindBy(xpath = "//*[@name=\"password\"]")
	private WebElement password;
	
	@FindBy(xpath="//*[@type=\"submit\"]")
	private WebElement submitButt;
	

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sendUsernamePasswd(String p1, String p2) {
		username.sendKeys(p1);
		password.sendKeys(p2);
	}
	
	public void clearValues() {
		username.clear();
		password.clear();
	}
	
	public void submitButton() {
		submitButt.click();
	}
	
}
