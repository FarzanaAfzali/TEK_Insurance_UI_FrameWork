@Smoke @Regression
Feature: Testing Plans

  Background: Login Steps
    When Navigate to TEK Insurance App click on Login Button
    And Type username "supervisor"
    And Type password "tek_supervisor"
    Then Click on Sign In Button
    And Navigate to the Plan page

  @US_9
  Scenario: Login with valid CSR credential and navigate to Plan page
    and verify presence of 4 rows of data

    Then Validate existence of 4 rows of data
