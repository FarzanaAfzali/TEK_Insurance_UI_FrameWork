package Tek_UI_BDD_FrameWork.Utility;

import Tek_UI_BDD_FrameWork.BaseSetUp.Base;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends Base {

    // explicitlyWait
    public WebDriverWait explicitly_Wait(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        return wait;
    }

    public WebElement get_element(By locator){
        return explicitly_Wait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> get_elements_list(By locator){
        return explicitly_Wait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    // get Element text
    public String get_element_text(By locator){
        return get_element(locator).getText();
    }

    // visibility of elements
    public boolean visibility_of_element(By locator){
        return get_element(locator).isDisplayed();
    }

    //click button
    public void click_element(By locator){
        getDriver().findElement(locator).click();
    }

    //sendKeys()
    public void send_text(By locator, String text){
        get_element(locator).sendKeys(text);
    }

    // Using Select from Java for Dropdowns
    public void select_from_DropDown(By locator, String value){
        Select select = new Select(get_element(locator));
        select.selectByValue(value);
    }
    // get list of elements
    public List<WebElement> List_elements(By locator){
        return get_elements_list(locator);
    }

    //loop through list of WebElement with assertion
    public void webElement_list_check(By locator, String expectedValue){
        List<WebElement> elements_list = get_elements_list(locator);
        String assertionMessage =  "Validating " + expectedValue + ":";
        for (WebElement element: elements_list){
            String actualValue = element.getText();
            if (expectedValue.contains(actualValue)){
                Assert.assertEquals(assertionMessage, expectedValue, actualValue);
                System.out.println("expected title: " + expectedValue);
                System.out.println("actual title: " + actualValue);
            }
        }
    }

    // get string and compare it with param
    public void getString_assert(By locator, String expectedValue, String message){
        String actualValue = get_element_text(locator);
        System.out.println(actualValue);
        Assert.assertEquals(message
                            ,expectedValue
                            ,actualValue);
    }

    // Screenshot
    public byte[] take_screenShot(){
        TakesScreenshot screenShot = (TakesScreenshot) getDriver();
        return screenShot.getScreenshotAs(OutputType.BYTES);
    }

    // screenshot for the end of test
    public void after_Test_screenShot(Scenario test_Scenario){
        String test_Status;
        byte[] screenShot = take_screenShot();

        if (test_Scenario.isFailed()) test_Status = "Test Failed!";
        else test_Status = "Test Passed!";

        test_Scenario.attach(screenShot, "image/png", test_Status);
    }


}
