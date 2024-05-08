
@tag
Feature: Purchase the order from Ecommerce Website
  
Background:
Given I landed on Amazon website

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When Search for product <product> and select the product <productName> from screen
    And Add the product to cart and proceed to Buy
    Then Select the address and use this address

    Examples: 
      | name                | password   |product   |productName                                      |
      |prajeevknd@gmail.com | Ganga@3535 |redmi10   |Redmi 10 (Caribbean Green, 4GB RAM, 64GB Storage)|
     
