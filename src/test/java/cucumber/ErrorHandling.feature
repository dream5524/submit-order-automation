@tag
Feature: Error Validaiton

	@ErrorHandling2
  	Scenario: Show error message with invalid credentials 
   		Given I launched on Ecommerce Website
    	When Login with email <email> and password <password>
   		Then "Incorrect email or password." error message is displayed
   		Examples:
				|email 					| password			|
				|mohuyen@gmail.com 		| M@huyen524add		|
		   