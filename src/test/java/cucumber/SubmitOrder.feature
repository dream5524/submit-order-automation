
@tag
Feature: Purchase order from Ecommerce website

	Background:
	Given I launched on Ecommerce Website
	
	@Regression2
	Scenario Outline: Positive data of Submitting order
	
		Given Login with email <email> and password <password>
		When Added product <productName> to Cart Page
		And Checkout <productName> and submit order
		Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page

		Examples:
		
				|email					|password			|productName |
				|mohuyen@gmail.com		|M@huyen524			|ZARA COAT 3 |