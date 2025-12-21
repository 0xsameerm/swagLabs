Feature: Social Media Links Validations

  Background:
    Given user is on the swag labs login page
    When user enters the username "standard_user"
    And user enters the password "secret_sauce"
    And clicks on login button

    Scenario: To verify social media links works correctly
      Given user is on the home page
      Then scrolls down the page
      And clicks on twiiter logo
      Then user is navigated to twiiter profile page in new tab

      When user closes the tab then user is navigated to the home page

      Given user clicks on facebook logo
      Then user is navigated to facebook profile page in new tab

      When user closes the tab then user is navigated to the home page

      Given user clicks on Linkedin logo
      Then user is navigated to Linkedin profile page in new tab