package com.framework.automation.cucumber.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QunarAccountPage extends AbstractPage {

	public QunarAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static QunarAccountPage instance;
	private final String URL = "https://user.qunar.com/passport/login.jsp?ret=https%3A%2F%2Fwww.qunar.com%2F";

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWord;
	
	@FindBy(xpath = "//input[@name='vcode']")
	private WebElement verificationCode;
	
	@FindBy(id="submit")
	private WebElement loginInButton;
	
	public static QunarAccountPage getInstance() {
		if (QunarAccountPage.instance == null) {
			QunarAccountPage.instance = new QunarAccountPage(driver);
		}
		return QunarAccountPage.instance;
	}

	public void openPage() {
		driver.navigate().to(URL);
	}
	
	public void inputUsername(final String username) {
		userName.clear();
		userName.sendKeys(username);
	}
	
	public void inputPassword(final String password) {
		passWord.clear();
	    passWord.sendKeys(password);
	}
	
	public void inputVcode(final String verificationcode) {
		verificationCode.clear();
		verificationCode.sendKeys(verificationcode);
	}
	
	public void sendSubmitButton() {
		loginInButton.click();
	}
	
}
