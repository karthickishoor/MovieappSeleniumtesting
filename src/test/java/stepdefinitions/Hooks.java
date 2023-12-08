package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\IntelJAutomation\\chromedriver\\chromedriver.exe" );
        driver=new ChromeDriver();
    }

    @After
    public void Teardown(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
