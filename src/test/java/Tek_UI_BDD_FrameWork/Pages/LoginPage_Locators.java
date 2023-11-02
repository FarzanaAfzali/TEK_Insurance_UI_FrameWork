package Tek_UI_BDD_FrameWork.Pages;

import org.openqa.selenium.By;

public class LoginPage_Locators {
    public static By LOGIN_BUTTON_PATH = new By.ByPartialLinkText("Login");
    public static By USERNAME_PATH = new By.ById("username");

    public static By PASSWORD_PATH = new By.ById("password");
    public static By SIGN_IN_BUTTON = new By.ByCssSelector(".css-jut409");
    public static By CUSTOMER_SERVICE_PORTAL_PATH = new By.ByClassName("css-1at26de");
    public static By DASHBOARD_PATH = new By.ByCssSelector(".css-1gp56vw");

    public static By USERNAME_PASSWORD_NOT_MATCHED = new By.ByClassName("chakra-alert");
}
