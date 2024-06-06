@tag
Feature: Error Validation
  @tag
  Scenario Outline: Negative test of error validation
 	  Given I landed on Ecommerce Page
    When logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed
    Examples: 
      | name             |        password |
      | anshika@gmail.com|     Iamking@0   |

