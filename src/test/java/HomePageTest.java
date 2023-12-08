import com.sun.source.tree.WhileLoopTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import pages.LoginPage;

import java.time.Duration;
import java.util.List;

public class HomePageTest {

    public WebDriver driver;
    public HomePage homepage;
    public WebDriverWait wait;


    @BeforeMethod
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\IntelJAutomation\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        homepage = new HomePage(driver);
        homepage.getvalidCredintials("rahul", "rahul@2021");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void checkallElementsinhomepage(){
        String actualhomepageheadingone = homepage.getheadingsforallsectionsinhomepage().get(0).getText();
        String expectedhomepageheadingone = "Trending Now";

        Assert.assertEquals(actualhomepageheadingone, expectedhomepageheadingone, "Heading one do not match");
        System.out.println("Heading one match");

        String actualhomepageheadingotwo = homepage.getheadingsforallsectionsinhomepage().get(1).getText();
        String expectedhomepageheadingtwo = "Originals";

        Assert.assertEquals(actualhomepageheadingotwo, expectedhomepageheadingtwo, "Heading Two do not match");
        System.out.println("Heading Two match");
        //}

        //@Test(priority = 2)
        //public void checkplaybuttonisvisibleinhomepage(){
        Assert.assertTrue(homepage.getplaybuttoninhomepage().isDisplayed(), "Play button is not displayed");
        System.out.println("Play button is displayed");
        //}

        //@Test(priority = 3)
        //public void checkallallElementsinhomepage(){
        int Trendingmoviecount = 0;
        int Originalsmoviecount = 0;

        for (WebElement trendingmovie : homepage.getalltrendingmovieimghomepage()) {
            Trendingmoviecount++;
        }
        //homepage.getthenextscrollarrowbutton().click();
        int expectedtredingmoviescount = 10;
        int actualtredingmoviescount = Trendingmoviecount;

        Assert.assertEquals(expectedtredingmoviescount, actualtredingmoviescount, "Not all 10 Trending movies are dispalyed");
        System.out.println("All 10 Trending movies are dispalyed");

        for (WebElement originalmovie : homepage.getalloriginalgmovieimghomepage()) {
            Originalsmoviecount++;
        }
        //homepage.getthenextscrollarrowbutton().click();
        int expectedOriginalsmoviescount = 10;
        int actualOriginalsmoviescount = Originalsmoviecount;

        Assert.assertEquals(expectedOriginalsmoviescount, actualOriginalsmoviescount, "Not all 10 Originals movies are dispalyed");
        System.out.println("All 10 Originals movies are dispalyed");
        //}

        //@Test(priority = 4)
        //public void checkContactussession(){

        String expectedcontactustext = "Contact Us";
        String actualcontactustext = homepage.getcontactustext();
        Assert.assertEquals(expectedcontactustext, actualcontactustext, "Contact us text is not displayed");
        System.out.println("Contact us text is displayed");
        //}

    }

    @AfterMethod
    public void teardown () {
        driver.close();
    }

}
