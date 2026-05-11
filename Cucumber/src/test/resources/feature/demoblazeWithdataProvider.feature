Feature: To check the demoblaze website

Scenario: login with invalid input
  Given user is on Homepage
  When user enters name and password
    | jeevs | 123 |
  And User clicks on the login button
  Then the error message seen as "Wrong password."