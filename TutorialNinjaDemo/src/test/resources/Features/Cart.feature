Feature: add the items to the cart

  @cart
  Scenario: add the items to the cart
    Given user is on the Account page
    When user click the product
      | itemNameSearch | itemNameCart |
      | mac            | iMac         |
      | mac            | MacBook      |
      | mac            | MacBook Air  |
    Then user verifies the items in the cart
      | cartProduct |
      | iMac         |
      | MacBook      |
      | MacBook Air  |
