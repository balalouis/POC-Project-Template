@login-feature
Feature: Login and Registration screen validation

  Scenario: Validate login screen ui
    When Launch the single activity
    Then I wait for 5 second
    And I should see the login ui

  Scenario: Validate login user input of username and password
    When Launch the single activity
    And I wait for 5 second
    Then I should see the login ui
    And I press login button
    Then I should see the "Data should not be empty"
    When I enter the username "asdfgh"
    And I should not see the keyboard
    And I enter the password "123456"
    And I should not see the keyboard
    Then I should able to see the entered input "asdfgh" and "123456"
    And I wait for 2 second
    When I press login button
    Then I should see the "Invalid credential"

