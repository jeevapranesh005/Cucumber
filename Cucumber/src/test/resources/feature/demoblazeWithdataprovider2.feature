Feature: check the invlaid login in demoblaze


@multiple_invalid
Scenario: login with invalid credentials
	Given uer is on homePage of demoblaze
	Then user enter invalid input and assert 
	|username|password|errormessage				              |
	|jeevs	 |123	  |Wrong password.    					  |
	|jeev@	 |123	  |User does not exist. 				  |

