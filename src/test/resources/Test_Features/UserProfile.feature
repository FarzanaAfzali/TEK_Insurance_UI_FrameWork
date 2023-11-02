Feature: User Profile and Log Out Validation

  Background: Login Steps
    When Navigate to TEK Insurance App click on Login Button
    And Type username "supervisor"
    And Type password "tek_supervisor"
    Then Click on Sign In Button
    And click on User Profile Button

  @US_7
  Scenario Outline: After login click on User Profile button and validate User Information
    And Validate User "<Status>"
    And The "<User Type>"
    And Name as "<Name>"
    And Username as "<Username>"
    And Authorities as "<Authorities>"
    Examples:
      | Status | User Type | Name       | Username   | Authorities |
      | Active | CSR       | Supervisor | supervisor | admin       |

  @US_8
    Scenario: Navigate to the TEK Insurance App, login click User Profile and click Logout Button
      to verify user can log out account and see the homepage

      And click on Logout Button
      Then for successful logout, verify the login button is visible and enabled

  Scenario: after logging in make sure the Theme button is enable and works as expected
    When Theme button should be enabled
    And click on Theme button and it should witch to "dark"
    Then click on Theme button again and change it to "light"