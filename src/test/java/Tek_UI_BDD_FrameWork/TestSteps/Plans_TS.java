package Tek_UI_BDD_FrameWork.TestSteps;

import Tek_UI_BDD_FrameWork.Pages.Plans_Locators;
import Tek_UI_BDD_FrameWork.Utility.SeleniumUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Plans_TS extends SeleniumUtility {
    // Navigate to Plan page
    @And("Navigate to the Plan page")
    public void planPage_navigation(){
        click_element(Plans_Locators.PLAN_PAGE_PATH);
    }

    // verify 4 rows of data
    @Then("Validate existence of {int} rows of data")
    public void planData_verification(int expectedRows){
        int actualRows = get_elements_list(Plans_Locators.PLAN_ROWS_DATA).size();
        System.out.println(actualRows);
        Assert.assertEquals("Plan Rows Verification: "
                , expectedRows
                , actualRows);





    }
}
