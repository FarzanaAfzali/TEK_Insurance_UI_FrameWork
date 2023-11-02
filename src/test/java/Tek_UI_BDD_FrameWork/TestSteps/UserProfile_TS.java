package Tek_UI_BDD_FrameWork.TestSteps;

import Tek_UI_BDD_FrameWork.Pages.LoginPage_Locators;
import Tek_UI_BDD_FrameWork.Pages.UserProfile_Locators;
import Tek_UI_BDD_FrameWork.Utility.SeleniumUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.cucumber.java.lv.Tad;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class UserProfile_TS extends SeleniumUtility {
    // click on userProfile button
    @And("click on User Profile Button")
    public void click_userProfile(){
        click_element(UserProfile_Locators.USER_PROFILE_BUTTON);
    }

    // validate Status
    @And("Validate User {string}")
    public void status_userInfo(String expectedData){
        getString_assert(UserProfile_Locators.STATUS_PATH, expectedData, "Status: ");
    }
    // validate User Type
    @And("The {string}")
    public void userType_userInfo(String expectedData){
        getString_assert(UserProfile_Locators.USER_TYPE, expectedData, "User Type: ");
    }

    // Validate name
    @And("Name as {string}")
    public void name_userInfo(String expectedData){
        getString_assert(UserProfile_Locators.NAME_PATH, expectedData, "Name: ");
    }

    //validate Username
    @And("Username as {string}")
    public void userName_userInfo(String expectedData){
        getString_assert(UserProfile_Locators.USER_NAME_PATH, expectedData, "Username: ");
    }

    //validate Authorities
    @And("Authorities as {string}")
    public void authority_userInfo(String expectedData){
        getString_assert(UserProfile_Locators.AUTHORITY_PATH, expectedData, "Authorities: ");
    }

    // click logout
    @And("click on Logout Button")
    public void click_logoutButton(){
        click_element(UserProfile_Locators.LOGOUT_BUTTON);
    }

    // verify logout by visibility of login button
    @Then("for successful logout, verify the login button is visible and enabled")
    public void verify_logOut(){
        if (visibility_of_element(LoginPage_Locators.LOGIN_BUTTON_PATH))
            System.out.println("Logout successfully");
        else System.out.println("Logout not successful");

    }
    //Theme Button enable
    @When("Theme button should be enabled")
    public void theme_button(){
        get_element(UserProfile_Locators.LIGHT_THEME_BUTTON).isEnabled();
    }
    // to dark mode
    @And("click on Theme button and it should witch to {string}")
    public void to_darkTheme(String expectedTheme){
        click_element(UserProfile_Locators.LIGHT_THEME_BUTTON);
        String actualTheme = get_element(UserProfile_Locators.DARK_THEME_BUTTON).getCssValue("color-scheme");
        Assert.assertEquals("Light to Dark Theme", expectedTheme, actualTheme);
    }

    // to light mode
    @Then("click on Theme button again and change it to {string}")
    public void to_lightTheme(String expectedTheme){
       // click_element(UserProfile_Locators.LIGHT_THEME_BUTTON);
        click_element(UserProfile_Locators.DARK_THEME_BUTTON);
        String actualTheme = get_element(UserProfile_Locators.LIGHT_THEME_BUTTON).getCssValue("color-scheme");
        Assert.assertEquals("Dark to Light Theme", expectedTheme, actualTheme);
    }
}
