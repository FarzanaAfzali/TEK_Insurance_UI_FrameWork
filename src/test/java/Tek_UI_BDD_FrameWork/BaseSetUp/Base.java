package Tek_UI_BDD_FrameWork.BaseSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    private static WebDriver driver;

    public void open_Browser(){
        //absolute path to property file:
        String propertyPath = System.getProperty("user.dir") + "/src/test/resources/Configs/QA_Env_Config.properties";

        //property instantiate
        Properties properties = new Properties();

        // using fileInputStream to lead property absolute path to the properties()
        // try and catch for FileInputStream and load() throws FileNotFound or IOException!
        try{
            FileInputStream config = new FileInputStream(propertyPath);
            properties.load(config);
        }catch (IOException e){
            e.printStackTrace();
        }

        // read property file and get URL and browser type
        String base_URL = properties.getProperty("ui.url");
        String browser_type = properties.getProperty("ui.browser.type");

        if (browser_type.equalsIgnoreCase("chrome")){
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless"); //chrome headless mode used in Linux Machines.
            //option.addArguments("__no_sandbox");
            //option.addArguments("__disable_dev_shm_usage");
            driver = new ChromeDriver(option);
        }else if (browser_type.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }else throw new RuntimeException("Wrong Browser Type Selected!");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get(base_URL);
    }

    public void close_Browser(){
        if (driver != null) driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
