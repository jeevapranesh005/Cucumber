Feature: Add to Cart Functionality

  Background:
    Given the user is on the product page

  @AddSingleProduct
  Scenario: Add a single product to the cart
    When the user clicks on the product "Samsung Galaxy"
    And the user clicks the "Add to Cart" button
    Then the user should get the alert message

  @AddMultipleProducts
  Scenario: Add multiple products to the cart
    When the user clicks on the product "Samsung Galaxy"
    And the user clicks the "Add to Cart" button
    And the user clicks on the product "iPhone 14"
    And the user clicks the "Add to Cart" button
    And the user clicks the cart icon
    Then the user should see both products on the cart page