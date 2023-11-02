@Smoke @Regression
Feature: Create Account

  @US_2
  Scenario: After Navigating to home page, click one Create Primary Account and the Create Primary Account Holder should open
    When Navigating to home page click on Create Primary Account button
    Then Validate "Create Primary Account Holder" as form title

  @US_3
  Scenario Outline: Create Account, sign up and validate email address
    #* def AutoEmail = Java.type('DataGenerators.DataGenerator')
    When Navigating to home page click on Create Primary Account button
    And Type in email address "<email>"
    And Choose the prefix as "<title>"
    And Type in first name "<name>"
    And Type in last name "<lName>"
    And Select gender as "<gender>"
    And Select Marital Status as "<maritalStatus>"
    And Type in Employment Status as "<empStatus>"
    And Select DOB as "<DOB>"
    Then click on Create Account button
    When Validate user navigate to "Sign up your Account" page
    And Validate email address as "<email>"
    Examples:
      | email                      | title | name    | lName  | gender | maritalStatus | empStatus | DOB        |
      | afzalifarzana297@gmail.com | Mrs.  | farzana | Afzali | FEMALE | MARRIED       | SDET      | 04/22/1998 |

    @US_4
    Scenario Outline: Creating account with existed Email address and error message
      When Navigating to home page click on Create Primary Account button
      And Type in email address "<email>"
      And Choose the prefix as "<title>"
      And Type in first name "<name>"
      And Type in last name "<lName>"
      And Select gender as "<gender>"
      And Select Marital Status as "<maritalStatus>"
      And Type in Employment Status as "<empStatus>"
      And Select DOB as "<DOB>"
      Then click on Create Account button
      When Verify "Account with email afzalifarzana297@gmail.com is exist"
      Examples:
        | email                      | title | name    | lName  | gender | maritalStatus | empStatus | DOB        |
        | afzalifarzana297@gmail.com | Mrs.  | farzana | Afzali | FEMALE | MARRIED       | SDET      | 04/22/1998 |