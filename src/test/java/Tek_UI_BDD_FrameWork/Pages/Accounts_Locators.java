package Tek_UI_BDD_FrameWork.Pages;

import org.openqa.selenium.By;

public class Accounts_Locators {
    public static By ACCOUNTS_PAGE = new By.ByPartialLinkText("Accounts");
    public static By SHOW_ROWS_PER_PAGE = new By.ByXPath("//tbody/tr");
    public static By SELECT_PER_PAGE = new By.ByCssSelector(".css-161pkch");
}
