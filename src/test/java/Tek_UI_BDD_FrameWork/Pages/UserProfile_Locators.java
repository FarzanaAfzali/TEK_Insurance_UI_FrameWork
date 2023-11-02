package Tek_UI_BDD_FrameWork.Pages;

import org.openqa.selenium.By;

public class UserProfile_Locators {
    public static By USER_PROFILE_BUTTON = new By.ByCssSelector(".css-1lzp9bh");

    public static By AUTHORITIES_PATH = new By.ByClassName("css-155za0w");
    public static By USER_INFO_PATH = new By.ByCssSelector(".css-6phkm9");
    public static By LOGOUT_BUTTON = new By.ByCssSelector(".css-1x18d5s");
    public static By LIGHT_THEME_BUTTON = new By.ByCssSelector(".css-22xpxh");
    public static By DARK_THEME_BUTTON = new By.ByCssSelector(".css-16mfj2s");
    public static By STATUS_PATH = new By.ByClassName("css-1ny2kle");
    public static By USER_TYPE = new By.ByXPath("//*[@id='chakra-modal--body-:r3:']/div/div/div[2]/p[2]");
    public static By NAME_PATH = new By.ByXPath("//*[@id='chakra-modal--body-:r3:']/div/div/div[3]/p[2]");
    public static By USER_NAME_PATH = new By.ByXPath("//*[@id='chakra-modal--body-:r3:']/div/div/div[4]/p[2]");
    public static By AUTHORITY_PATH = new By.ByXPath("//*[@id='chakra-modal--body-:r3:']/div/div/div[5]/ul/li");


}
