$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/LoginTest.feature");
formatter.feature({
  "line": 3,
  "name": "Login Action",
  "description": "I want to use this template for my feature file",
  "id": "login-action",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User Navigate to Login Page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User enters UserName \"testuser_1\" and Password \"Test@123\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Close Home Page",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 223998031009,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_Navigate_to_Login_Page()"
});
formatter.result({
  "duration": 784812691,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testuser_1",
      "offset": 22
    },
    {
      "val": "Test@123",
      "offset": 48
    }
  ],
  "location": "Steps.user_enters_UserName_and_Password(String,String)"
});
formatter.result({
  "duration": 135844355896,
  "status": "passed"
});
formatter.match({
  "location": "Steps.close_Home_Page()"
});
formatter.result({
  "duration": 3797484100,
  "status": "passed"
});
});