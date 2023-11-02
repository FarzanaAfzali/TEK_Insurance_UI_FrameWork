package Tek_UI_BDD_FrameWork.TestSteps;

import Tek_UI_BDD_FrameWork.Utility.SeleniumUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends SeleniumUtility {

    @Before
    public void before_Test(){
        open_Browser();
    }

    @After
    public void after_Test(Scenario test_scenario){
        after_Test_screenShot(test_scenario);
        close_Browser();
    }
}
