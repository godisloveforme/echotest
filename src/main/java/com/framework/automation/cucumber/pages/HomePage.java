package com.framework.automation.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

	private static HomePage instance;
	
	private final String URL = "http://store.demoqa.com/";
	
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccount;
	
	public HomePage(WebDriver driver)
    {
            super(driver);
    }

	public static HomePage getInstance() {
		if(HomePage.instance==null) 
		{
			HomePage.instance = new HomePage(driver);
		}
		return HomePage.instance;
	}
	
	public void openPage()
	{
		driver.navigate().to(URL);
	}
	
	public void closePage()
	{
		driver.quit();
	}
	
	public AccountPage goToAccountPage() {
		myAccount.click();
		return new AccountPage(driver);
	}
	
}
