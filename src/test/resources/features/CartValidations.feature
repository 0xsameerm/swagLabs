Feature: Cart Validations

  Background:
    Given user is on the swag labs login page
    When user enters the username "standard_user"
    And user enters the password "secret_sauce"
    And clicks on login button

    Scenario Outline: To add multiple items to cart and verify the count
      Given user is on the home page
      And adds <count> items to cart
      Then cart badge should display the number of items in the cart correctly

      Examples:
      | count |
      | 3     |