package com.framework.automation.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.framework.automation.cucumber.driver.WebDriverSingleton;

public abstract class AbstractPage {

	//protected final WebDriver driver;
    protected final static WebDriver driver = WebDriverSingleton.getWebDriverInstance();
	
	public AbstractPage(WebDriver driver) {
		PageFactory.initElements(AbstractPage.driver, this);
	}

	public WebDriver getDriver() {
		return AbstractPage.driver;
	}

	public void quitDriver(){
		AbstractPage.driver.quit();
	}
//	public Boolean isElementPresent(By locator) {
//		return driver.findElements(locator).size() > 0;
//	}

}
