package Tek_UI_BDD_FrameWork.TestSteps;

import Tek_UI_BDD_FrameWork.Pages.LoginPage_Locators;
import Tek_UI_BDD_FrameWork.Utility.SeleniumUtility;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Login_TS extends SeleniumUtility {
    // click on Login Button
    @When("Navigate to TEK Insurance App click on Login Button")
    public void click_loginButton(){
        click_element(LoginPage_Locators.LOGIN_BUTTON_PATH);
    }

    // type the username
    @And("Type username {string}")
    public void type_userName(String username){
        send_text(LoginPage_Locators.USERNAME_PATH, username);
    }

    // type the password
    @And("Type password {string}")
    public void type_password(String password){
        send_text(LoginPage_Locators.PASSWORD_PATH, password);
    }

    // click Sign In Button
    @Then("Click on Sign In Button")
    public void click_SignIn(){
        click_element(LoginPage_Locators.SIGN_IN_BUTTON);
    }

    // Verify Customer Service Portal
    @And("validate login by visibility of {string}")
    public void verifyLogin(String expectedTitle)throws InterruptedException{
        String message = "Validate Login as visibility of Dashboard";
        Thread.sleep(3000);
        getString_assert(LoginPage_Locators.CUSTOMER_SERVICE_PORTAL_PATH,expectedTitle,message);

    }

    //validate errorMessage for Negative Data
    @And("validate {string} as message")
    public void login_errorMessage_validation(String expectedError){
        String actualError = get_element_text(LoginPage_Locators.USERNAME_PASSWORD_NOT_MATCHED).replace("ERROR","").trim();
        Assert.assertEquals("errorMessage", expectedError, actualError);
    }


}
