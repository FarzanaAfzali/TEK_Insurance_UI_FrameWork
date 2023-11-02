@Smoke
Feature: Validation of home page title as "TEK Insurance App"
  and existence of "Create Primary Account" button.

  @US_1
  Scenario: Validate When user navigate to home page title is TEK Insurance App
    When Validate application title is "Tek Insurance UI"
    When Validate Home Page title is "TEK Insurance App"
    Then Validate Button for Create Primary Account is enable and clickable


