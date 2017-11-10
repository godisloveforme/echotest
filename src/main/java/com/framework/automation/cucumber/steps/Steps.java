package com.framework.automation.cucumber.steps;

import com.framework.automation.cucumber.pages.AccountPage;
import com.framework.automation.cucumber.pages.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Steps {

	HomePage homePage = HomePage.getInstance();
	AccountPage accountPage = AccountPage.getInstance();
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		homePage.openPage();
	}

	@When("^User Navigate to Login Page$")
	public void user_Navigate_to_Login_Page() throws Throwable {
	    homePage.goToAccountPage();
	}
	
	@Given("^User enters UserName \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_enters_UserName_and_Password(final String userName, final String passWord) throws Throwable {
		accountPage.accountLogin(userName, passWord);
	}
	
	@Then("^Close Home Page$")
	public void close_Home_Page() throws Throwable {
	    homePage.closePage();
	}
	
	@Given("^User is on Account Page$")
	public void user_is_on_Account_Page() throws Throwable {
		accountPage.openPage();
	}
}
