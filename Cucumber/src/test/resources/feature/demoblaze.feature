Feature: To check the demoblaze website

@invalidInput
Scenario Outline:
	Given user is on Homepage
	When  user enter username as "<username>" and password as "<password>"
	And User clicks on the login button
	Then the error message seen as "<errormessage>"
	
	Examples:
|username|password|errormessage				              |
|jeevs	 |123	  |Wrong password.    					  |
|jeev@	 |123	  |User does not exist. 				  |
|	     |	      |Pleasej fill out Username and Password. |