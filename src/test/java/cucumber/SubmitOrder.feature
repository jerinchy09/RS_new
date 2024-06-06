@tag
Feature: Purchase the order fromEcommerce Website

	Background: 
	Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive test of Submitting the order
    Given logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage
    Examples: 
      | name             |        password | productName |
      | anshika@gmail.com|     Iamking@000 | ZARA COAT 3 |
