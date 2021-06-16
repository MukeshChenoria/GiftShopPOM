Feature: Gift Shop login.

Scenario: Checking the availability of various labels fields and button.
Given Environment Setup for checking the availability.
Given User is on the login page already.
Then User checks the availability of Username and Password labels.
Then User checks the availability of Username and Password fields.
Then user checks the availability of login button, Sign Up Now button, and Back button.
Then User checks whether Sign Up Now button is clickable or not and is taking to the registration page or not.
Then User checks whether Back button is clickable or not and is taking to the homepage or not.

Scenario Outline: Test login function of Gift Shop Application with invalid credentials.
Given Environment Setup.
Given User is already on the login page.
Then User enters invalid "<username>" and invalid "<password>".
Then user clicks on login button.
And user is still on the login page

		Examples:
			|	name	| username 				| password 				|
			| name1	|	invalidusername	|	invalidpassword |
			|	name3	|	admin						|	invalidpassword	|
			|	name4	|	invalidusername	|	admin						|
			|	name5	|	admin						|									|
			|	name6	|									|	admin						|
			|	name7	|									|									|
			

Scenario: Test login function of Gift Shop Application with correct credentials.
		Given Environment Setup2.
		Given user is on the login page.
		Then User enters correct username and password.
		Then User clicks on login button again.
		And User cart is available.
			