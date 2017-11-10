package com.framework.automation.cucumber.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver implements WebDriver {

	private static Driver driver = null;
	private static WebDriver instance = null;
	private static final String DEFAULT_WEB_DRIVER = "DEFAULT_WEB_DRIVER";
	private static WebDriverTypes defaultDriverType = WebDriverTypes.FIREFOX;
	private static HashMap<String, org.openqa.selenium.WebDriver> instances;
	
	public WebDriver getInstance() {
		return instance;
	}
	
	private Driver() {
		
	}
	
	public static Driver getWebDriverInstance(String name, WebDriverTypes type) throws Exception {
		if (!instances.containsKey(name))
		{
			switch (type) {
			case FIREFOX: {
				instance = new FirefoxDriver();
				driver = new Driver();
				break;
			}
			case IE: {
				instance = new InternetExplorerDriver();
				driver = new Driver();
				break;
			}
			case CHROME: {
				instance = new ChromeDriver();
				driver = new Driver();
				break;
			}
			default: 
				throw new Exception("Unknown web driver specified: " + type);
			}
			instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			instances.put(name, instance);
		} else {
			instance = instances.get(name);
		}
		return driver;
	}
	
	public static Driver getWebDriverInstance(String name) throws Exception {
		return getWebDriverInstance(name, defaultDriverType);
	}
	
	public static Driver getWebDriverInstance() throws Exception {
		return getWebDriverInstance(DEFAULT_WEB_DRIVER, defaultDriverType);
	}
	
	public void get(String url) {
		// TODO Auto-generated method stub
		
	}

	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

}
