package com.framework.automation.cucumber.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebDriverSingleton {

    private static WebDriver driver;
    private static WebDriverTypes webDriverType = WebDriverTypes.FIREFOX;

    private WebDriverSingleton() {}

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            //driver = new FirefoxDriver();
           switch (WebDriverSingleton.webDriverType)
           {
           case FIREFOX:{
        	   driver = new FirefoxDriver(); 
        	   driver.manage().window().maximize();
        	   break;}
           case IE:{ break;}
           case CHROME: {
               System.setProperty("webdriver.chrome.driver", "C:\\Users\\huang\\workspace\\CucumberFramework\\src\\main\\resources\\driver\\chromedriver.exe");
               driver = new ChromeDriver();
           }
           default:
           }
        }
        return driver;
    }

    public static void closeWebBrowser(){
        driver.quit();
        driver = null;
    }

}
