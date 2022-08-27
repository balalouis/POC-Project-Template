@login-feature
Feature: Login and Registration screen validation

  Scenario: Validate registration ui
    When Launch the single activity
    Then I wait for 5 second
    And I should see the login ui
    Then I press register button from login_screen
    And I should see the register screen ui


  Scenario: Validate registration ui credential
    When Launch the single activity
    Then I wait for 5 second
    And I should see the login ui
    Then I press register button from login_screen
    And I should see the register screen ui
    When I enter the username registration ""
    And I should not see the keyboard
    When I enter the email registration ""
    And I should not see the keyboard
    When I enter the password registration ""
    And I should not see the keyboard
    Then I press register button
    Then I should see the "Data should not be empty"
    When I enter the username registration "eve.holt@reqres.in"
    And I should not see the keyboard
    And I enter the email registration "eve.holt@reqres.in"
    And I should not see the keyboard
    And I enter the password registration "pistol"
    And I should not see the keyboard
    Then I press register button
    And I wait for 2 second
    Then I should see the user list ui


