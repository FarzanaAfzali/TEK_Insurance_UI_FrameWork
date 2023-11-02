@Regression @Smoke
Feature: Security Test

  @US_5
  Scenario: Validate login
    When Navigate to TEK Insurance App click on Login Button
    And Type username "supervisor"
    And Type password "tek_supervisor"
    Then Click on Sign In Button
    And validate login by visibility of "Customer Service Portal"

    @US_6
  Scenario Outline: Test login with Negative data
    When Navigate to TEK Insurance App click on Login Button
    And Type username "<username>"
    And Type password "<password>"
    Then Click on Sign In Button
    And validate "<errorMessage>" as message
    Examples:
      | username       | password       | errorMessage                  |
      | wrong_username | tek_supervisor | User wrong_username not found |
      | supervisor     | wrong_password | Password not matched          |