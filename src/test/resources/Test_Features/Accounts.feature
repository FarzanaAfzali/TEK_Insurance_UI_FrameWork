@Regression
Feature: TEK Insurance App Accounts page Tests

  Background: Login Steps
    When Navigate to TEK Insurance App click on Login Button
    And Type username "supervisor"
    And Type password "tek_supervisor"
    Then Click on Sign In Button
    And Click on the Accounts Page

  @US_10
  Scenario: Login to TEK Insurance App and and after navigating to the Accounts page
          confirm 5 rows/page is default

    Then Verify there are 5 rows displayed per page

  @US_11
  Scenario Outline: After Login, Navigate to Accounts and change show record per page to 10, 25, 50
    and validate table records per page matches the number of selected rows

    And Change record per page to "<Show>" and confirms number of records matches the selected number
    Examples:
      | Show |
      | 10   |
      | 25   |
      | 50   |
