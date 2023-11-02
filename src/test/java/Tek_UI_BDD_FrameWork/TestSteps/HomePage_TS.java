package Tek_UI_BDD_FrameWork.TestSteps;

import Tek_UI_BDD_FrameWork.Pages.HomePage_Locators;
import Tek_UI_BDD_FrameWork.Utility.SeleniumUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePage_TS extends SeleniumUtility {

    // PageTitle
    @When("Validate application title is {string}")
    public void title_page(String expectedTitle){
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals("Page Title: ",expectedTitle, actualTitle);
    }

    // validate homePage Title
    @When("Validate Home Page title is {string}")
    public void page_title_validation(String expectedTitle){
        String message = "HomePage Title Text";
        getString_assert(HomePage_Locators.HOMEPAGE_TITLE,expectedTitle,message);
}

    // Validate visibility of Create Primary Account
    @Then("Validate Button for Create Primary Account is enable and clickable")
    public Boolean create_account_button(){
        Boolean button_status = visibility_of_element(HomePage_Locators.CREATE_PRIMARY_ACCOUNT);
        if (button_status) System.out.println("Button is enable");
        else System.out.println("Button is disable");
        return button_status;
    }

}
