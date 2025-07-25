Feature: To check the Login functionality

  Background:
    Given user is on the swag labs login page

  Scenario: Verify login with valid credentials
    When user enters the username "standard_user"
    And user enters the password "secret_sauce"
    And clicks on login button
    Then user is navigated to the home page

  Scenario: Verify empty login
    And clicks on login button
    Then an error message is displayed

  Scenario Outline: Verify login with valid username and invalid password
    When user enters the "<username>" and "<password>"
    And clicks on login button
    Then an error message is displayed

    Examples:
      |username|password|
      |standard_user|sssssss|

  Scenario Outline: Verify login with invalid username and valid password
    When user enters the "<username>" and "<password>"
    And clicks on login button
    Then an error message is displayed

    Examples:
      |username|password|
      |sssss|secret_sauce|

