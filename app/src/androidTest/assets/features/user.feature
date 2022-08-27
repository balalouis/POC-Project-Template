@user-feature
Feature: Login and Registration screen validation

  Scenario: Validate user list item event
    When Launch the single activity
    And I wait for 5 second
    Then I should see the login ui
    When I enter the username "eve.holt@reqres.in"
    And I should not see the keyboard
    When I enter the password "cityslicka"
    Then I should not see the keyboard
    When I press login button
    And I wait for 2 second
    Then I should see the user list ui
    When I tap on second item in list
    And I wait for 2 second
    Then I should see the user detail ui

