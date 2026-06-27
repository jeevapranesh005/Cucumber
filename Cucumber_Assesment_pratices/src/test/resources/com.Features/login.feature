Feature: Jeeva Pranesh 12-05-2026_login to tutorial ninja
Description: As a user i want to login  to the tutorial ninhja

Background:
Given user is on the home page of tutorial ninja
When a user click the myAccount link
And a user click the login link

@valid
Scenario Outline: login with valid data
When a user Enter the E-Mail "<email>" and password "<password>"
And  a user click the login button
Then user seen the myAccount

Example:
|email			   |password  |
|tamilkumargmail.com|Kiot123|


@invalid
Scenario Outline: login with invalid data
When a user enter the incorrect email "<email>" and password "<password>"
And a user click the login button
Then user should seen the error message

Example:
|email|password|
|jeeva|jeeva@11111|

