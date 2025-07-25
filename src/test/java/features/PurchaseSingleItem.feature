Feature: Purchase single item

  Background:
    Given user is on the swag labs login page
    When user enters the username "standard_user"
    And user enters the password "secret_sauce"
    And clicks on login button

  Scenario: To verify whether the user is able to complete purchase of any single item
    Given user is on the home page
    When user clicks on Add to cart button of Sauce Labs Backpack
    Then "1" is displayed in the cart

    When user clicks on cart icon on top right of the page
    Then the user is redirected to the Your Cart page
    And the selected product details is displayed

    When user clicks on Checkout button
    Then user is navigated to the Checkout: Your Information page

    When user Enters First Name "Jesse" , Last Name "pinkman" and Postal code "323212"
    And click on Continue button
    Then user is navigated to the Checkout: Overview page

    When user clicks on Finish button
    Then user is navigated to the Checkout: Complete! page



