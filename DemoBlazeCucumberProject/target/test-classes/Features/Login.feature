Feature: TamilKumar Login Feature

  Background:
    Given User on the home page
    When User click the login button
   

  @ValidCredentials
  Scenario: Login With valid credentials
   And Enter the username and password and click the Login button
    Then User can see the name of the user

  @InvalidCredentials
  Scenario: Login with Invalid Credentials
   And Enter the invalid username and password and click the Login button
	Then user can see the user does not exist