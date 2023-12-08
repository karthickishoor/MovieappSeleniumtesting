import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.util.Scanner;

public class SearchPageTest {
    public WebDriver driver;
    public SearchPage searchPage;
    public int moviescount=0;
    public Actions action;


    @BeforeMethod
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\IntelJAutomation\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        searchPage = new SearchPage(driver);
        searchPage.getvalidCredintials("rahul", "rahul@2021");
        driver.manage().window().maximize();
        action= new Actions(driver);
    }

    @Test
    public void checkserachpagefunctionality(){
        searchPage.getserachbutton().click();
        searchPage.getmoviename().sendKeys("venom");
        action.click(searchPage.getserachbutton()).perform();

        for (WebElement movie: searchPage.getmovieslisted()){
            moviescount++;
        }
        int expectedmoviescount=2;
        Assert.assertEquals(moviescount,expectedmoviescount,"All the movies that were searched for are not listed");
        System.out.println("All the movies that were searched for are listed");
    }

    @AfterMethod
    public void Teardown(){
        driver.close();
    }
}
