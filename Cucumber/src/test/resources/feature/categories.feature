Feature: Categories feature for list the product


Background: Given the user is on the the Homepage after login


@categories_mobile
Scenario: Choose the categories of mobile 
	
	When the user click the "mobile" opiton in the categories list
	Then the webiste should list the only the mobile product 
	
	
@categorie_laptop
Scenario: Choose the categories of laptop 
	
	When the user click the "laptop" opiton in the categories list
	Then the webiste should list the only the laptop product 
	
	
@categories
Scenario: Choose the categories of monitor 
	
	When the user click the "monitor" opiton in the categories list
	Then the webisteshould list the only the monitor product 
