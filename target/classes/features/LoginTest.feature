
@tag
Feature: Login Action
	I want to use this template for my feature file

@tag1
Scenario: Successful Login with Valid Credentials 
Given User is on Home Page 
When User Navigate to Login Page
And User enters UserName "testuser_1" and Password "Test@123"
Then Close Home Page
	

#@tag2
#Scenario Outline: Successful LogOut
#Given User is on Account Page 
#When User Navigate to Login Page
#And User enters UserName "testuser_1" and Password "Test@123"
#Then Close Home Page
#Given I want to write a step with <name>
#When User LogOut from the Application
#Then Message displayed LogOut Successfully
#
#Examples:
    #| name  |value | status |
    #| name1 |  5   | success|
    #| name2 |  7   | Fail   |