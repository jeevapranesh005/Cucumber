Feature: Tamil_06_05_2005_Login feature

  Background:
    Given user on the home page
    And click login Button

 @ValidCredentials
Scenario Outline: User login valid credentials
  When User enters the "<username>"
  And user enters the "<password>" and click the Login Button
  Then user should show the logout button "<Assertion>"

  Examples:
    | username             | password | Assertion                         |
    | tamilkumar@gmail.com | Kiot1234 | Edit your account information     |

@InvalidCredentials
Scenario Outline: Login with Invalid credentials
  When User enters the "<username>"
  And user enters the "<password>" and click the Login Button
  Then user should show the error message "<Assertion>"

  Examples:
    | username           | password | Assertion                                              |
    | tamilkum@gmail.com | Kiot1234 | Warning: No match for E-Mail Address and/or Password.  |
