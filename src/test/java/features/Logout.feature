Feature: To check the logout functionality

  Scenario Outline: Verify Logout functionality
  Given user is on the swag labs login page
  When user enters the "<username>" and "<password>"
  And clicks on login button
  Then user is navigated to the home page

  When user clicks on Hamburger icon
  And clicks on logout button
  Then user is navigated to the login page


  Examples:
  |username|password|
  |standard_user|secret_sauce|