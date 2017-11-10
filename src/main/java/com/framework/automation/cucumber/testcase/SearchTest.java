package com.framework.automation.cucumber.testcase;

import org.testng.annotations.Test;

import com.framework.automation.cucumber.pages.QunarBookingPage;
import com.framework.automation.cucumber.utilities.DateUtil;


public class SearchTest {
	private QunarBookingPage bookingPage = QunarBookingPage.getInstance();
	
	@Test(description = "Test search flight")
	public void searchFlight() throws InterruptedException {
		bookingPage.openPage();
		bookingPage.inputFromCity("guangzhou");
		bookingPage.inputToCity("taipei");
	    bookingPage.inputStartDate(DateUtil.getFutureDate(DateUtil.DATE_DEFAULT_FORMAT, Integer.valueOf("7").intValue()));
	    bookingPage.clickSearch();
	}
	
	

}
