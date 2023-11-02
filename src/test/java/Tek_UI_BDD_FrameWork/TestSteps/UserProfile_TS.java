package Tek_UI_BDD_FrameWork.TestSteps;

import Tek_UI_BDD_FrameWork.Pages.LoginPage_Locators;
import Tek_UI_BDD_FrameWork.Pages.UserProfile_Locators;
import Tek_UI_BDD_FrameWork.Utility.SeleniumUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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

    // validate user's name, username and userType
    // still need more think if we can get separate field_name and use_info lists and make an assertion.
    @And("Validate User Information")
    public void check_userInfo(DataTable dataTable){
        List<List<String>> dataAsList = dataTable.asLists();
        List<String> expectedData = dataAsList.get(1);
        List<String> fields = dataAsList.get(0);

        List<WebElement> elementList = get_elements_list(UserProfile_Locators.USER_INFO_PATH);
        String actualValues = elementList.get(0).getText();

        for(int index = 0; index < expectedData.size(); index++) {
            String section_name = fields.get(index);
            String value = expectedData.get(index);
           if (actualValues.contains(value)) System.out.println(section_name + ": " + value);
           else System.out.println(section_name + ": " + value);
       }
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
}
