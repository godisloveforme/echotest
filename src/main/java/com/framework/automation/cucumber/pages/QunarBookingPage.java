package com.framework.automation.cucumber.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class QunarBookingPage extends AbstractPage {

	public QunarBookingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static QunarBookingPage instance;
	private final String URL = "http://flight.qunar.com/";

	@FindBy(xpath = "//a[text()='¹úÄÚ»úÆ±']")
	private WebElement domesticTicket;

	@FindBy(id = "searchTypeSng")
	private WebElement singleRadio;

	@FindBy(xpath = "//input[@data-qcbox-suggest='flight-fromcity']")
	private WebElement fromCity;

	@FindBy(xpath = "//input[@data-qcbox-suggest='flight-tocity']")
	private WebElement toCity;

	@FindBy(xpath = "//input[@name='fromDate']")
	private WebElement fromDate;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement serachButton;

	public static QunarBookingPage getInstance() {
		if (QunarBookingPage.instance == null) {
			QunarBookingPage.instance = new QunarBookingPage(driver);
		}
		return QunarBookingPage.instance;
	}

	public void openPage() {
		driver.navigate().to(URL);
	}

	public void inputFromCity(final String fromCityString) {
		fromCity.clear();
		fromCity.sendKeys(fromCityString);
		fromCity.sendKeys(Keys.ENTER);

	}

	public void inputToCity(final String toCityString) {
		toCity.clear();
		toCity.sendKeys(toCityString);
		toCity.sendKeys(Keys.ENTER);
	}

	public void inputStartDate(final String dateString) {
		//DateUtil.getFutureDate(DateUtil.DATE_DEFAULT_FORMAT, Integer.valueOf("7").intValue());
		fromDate.clear();
		fromDate.sendKeys(dateString);
	}
	
	public void clickSearch()
	{
		serachButton.click();
	}
}
