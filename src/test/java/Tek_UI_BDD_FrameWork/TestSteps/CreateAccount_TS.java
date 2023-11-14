package Tek_UI_BDD_FrameWork.TestSteps;

import Tek_UI_BDD_FrameWork.Pages.CreateAccountHolder_Locators;
import Tek_UI_BDD_FrameWork.Pages.HomePage_Locators;
import Tek_UI_BDD_FrameWork.Pages.SignUpAccount_Locators;
import Tek_UI_BDD_FrameWork.Utility.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateAccount_TS extends SeleniumUtility {

    // Click Create Account
    @When("Navigating to home page click on Create Primary Account button")
    public void click_CreatePAccount(){
        click_element(HomePage_Locators.CREATE_PRIMARY_ACCOUNT);
    }

    // validate Create Account Form Title
    @Then("Validate {string} as form title")
    public void create_account_formTitle(String expectedTitle) {
        String message = "Create Primary Account Form Title";
        getString_assert(CreateAccountHolder_Locators.CREATE_PRIMARY_ACCOUNT_HOLDER, expectedTitle, message);
    }
    // filling the form

    //send Email
    @And("Type in email address {string}")
    public void type_Email(String email){
        send_text(CreateAccountHolder_Locators.EMAIL_PATH, data_Generator());
    }

    // send title
    @And("Choose the prefix as {string}")
    public void type_Title(String title){
        select_from_DropDown(CreateAccountHolder_Locators.TITLE_PATH,title);
    }

    //Type firstName
    @And("Type in first name {string}")
    public void type_fName(String name){
        send_text(CreateAccountHolder_Locators.FIRST_NAME_PATH, name);
    }

    // Type lastName
    @And("Type in last name {string}")
    public void type_LName(String lName){
        send_text(CreateAccountHolder_Locators.LAST_NAME_PATH, lName);
    }

    //Gender
    @And("Select gender as {string}")
    public void type_Gender(String gender){
        select_from_DropDown(CreateAccountHolder_Locators.GENDER_PATH, gender);
    }

    //Marital Status
    @And("Select Marital Status as {string}")
    public void type_maritalStatus(String maritalStatus){
        select_from_DropDown(CreateAccountHolder_Locators.MARITAL_STATUS_PATH, maritalStatus);
    }

    // Employment Status
    @And("Type in Employment Status as {string}")
    public void type_empStatus(String empStatus){
        send_text(CreateAccountHolder_Locators.EMPLOYMENT_STATUS, empStatus);
    }

    //date of birth
    @And("Select DOB as {string}")
    public void type_DOB(String DOB){
        send_text(CreateAccountHolder_Locators.DATE_OF_BIRTH, DOB);

    }

    // click Create Account button
    @Then("click on Create Account button")
    public void click_CreateAccount(){
        click_element(CreateAccountHolder_Locators.CREATE_ACCOUNT_BUTTON);
    }

    // Sign Up your Account title verification
    @When("Validate user navigate to {string} page")
    public void signUp_Account(String expectedTitle){
        webElement_list_check(SignUpAccount_Locators.SIGN_UP_ACCOUNT_EMAIL_TITLE, expectedTitle);
    }

    // Validate email as expected
    @And("Validate email address as {string}")
    public void validate_emailAddress(String expectedEmail){
        webElement_list_check(SignUpAccount_Locators.SIGN_UP_ACCOUNT_EMAIL_TITLE, expectedEmail);
    }

    //verify error for duplicate email_address
    @When("Verify {string}")
    public void verify_errorMessage(String expectedMessage){
        String actualMessage = get_element_text(SignUpAccount_Locators.BANNER_ERROR_PATH).replace("ERROR", "").trim();
        Assert.assertEquals("Verify Duplicate errorMessage"
                ,expectedMessage
                ,actualMessage);
    }

}
