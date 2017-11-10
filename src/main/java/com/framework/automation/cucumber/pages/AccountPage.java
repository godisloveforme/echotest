package com.framework.automation.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage{

	private static AccountPage instance;
	private final String URL = "http://store.demoqa.com/products-page/your-account/";
	
	@FindBy(id = "log")
	private WebElement username;
	
	@FindBy(id = "pwd")
	private WebElement password;
	
	@FindBy(id = "login")
	private WebElement loginButton;
	
	
	
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	public static AccountPage getInstance() {
		if(AccountPage.instance==null) 
		{
			AccountPage.instance = new AccountPage(driver);
		}
		return AccountPage.instance;
	}

	public void openPage()
	{
		driver.navigate().to(URL);
	}
	
	public void closePage()
	{
		driver.quit();
	}
	
	public void accountLogin(final String userName, final String passWord)
	{
		username.sendKeys(userName);	
		password.sendKeys(passWord);
		loginButton.click();
}
	
}
