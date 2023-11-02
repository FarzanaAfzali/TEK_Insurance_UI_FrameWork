package Tek_UI_BDD_FrameWork.TestSteps;

import Tek_UI_BDD_FrameWork.Pages.Accounts_Locators;
import Tek_UI_BDD_FrameWork.Utility.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Accounts_TS extends SeleniumUtility {

    // click on the Accounts Page
    @And("Click on the Accounts Page")
    public void click_Accounts(){
        click_element(Accounts_Locators.ACCOUNTS_PAGE);
    }

    // verify 5 rows/page
    @Then("Verify there are {int} rows displayed per page")
    public void default_accounts_perPage(int expectedRow){
        List<WebElement> rowsList = get_elements_list(Accounts_Locators.SHOW_ROWS_PER_PAGE);
        int actualRow = rowsList.size();
        System.out.println(expectedRow);
        System.out.println(rowsList.size());
        Assert.assertEquals("Show 5 rows/page", expectedRow, actualRow);
    }

    // change show/perPage and verify the records number matches the chosen number
    @And("Change record per page to {string} and confirms number of records matches the selected number")
    public void accounts_perPage(String expectedRows){
        select_from_DropDown(Accounts_Locators.SELECT_PER_PAGE, expectedRows);
        int actualRows = get_elements_list(Accounts_Locators.SHOW_ROWS_PER_PAGE).size();
        Assert.assertEquals("Show "+ expectedRows + "/Page"
                            ,expectedRows
                            ,"" + actualRows);
    }
}
