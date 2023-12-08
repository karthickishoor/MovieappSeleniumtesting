import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderSection;
import pages.HomePage;

public class HeaderSectionTest {
    public WebDriver driver;
    public HeaderSection headersection;


    @BeforeMethod
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\IntelJAutomation\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        headersection = new HeaderSection(driver);
        headersection.getvalidCredintials("rahul", "rahul@2021");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void checkthenavbarUI(){
        Assert.assertEquals(headersection.getwebsitelogoofnavbar().isDisplayed(),true,"Website logo of navbar is not displayed");
        System.out.println("Websitelogo of navbar is displayed");

        Assert.assertEquals(headersection.getnavbarlistitems().get(0).getText(),"Home","Home text in nav bar is not displayed");
        System.out.println("Hometext in nav bar is displayed");
        Assert.assertEquals(headersection.getnavbarlistitems().get(1).getText(),"Popular","Popular text in nav bar is not displayed");
        System.out.println("Popular text in nav bar is displayed");

        Assert.assertEquals(headersection.getnavbarsearchemptybutton().isDisplayed(),true,"Search icon is not displayed");
        System.out.println("Serach icon is displayed");
    }

    @Test(priority = 2)
    public void checknavigationofhomepageandpopularmoviespage(){
        headersection.getnavbarlistitems().get(1).click();
        String expectedpopularpageUrl = "https://qamoviesapp.ccbp.tech/popular";
        String actualpopularpageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedpopularpageUrl,actualpopularpageUrl,"Navigation to popular movies page is not sucessfull");
        System.out.println("Navigation to popular movies page is sucessfull");


        headersection.getnavbarlistitems().get(0).click();
        Assert.assertEquals(headersection.gettohomepagenavitem().isDisplayed(),true,"Navigation to home page is not sucessfull");
        System.out.println("Navigation to home page is sucessfull");

    }

    @Test(priority = 3)
    public void checknavigationtoaccountpage(){
        headersection.getbuttonofaccountpage().click();

        String expectedheadingtextinaccountpage = "Account";
        String actualheadingtextinaccountpage = headersection.getaccountpageheading().getText();
        Assert.assertEquals(actualheadingtextinaccountpage,expectedheadingtextinaccountpage,"Navigation to account page is not sucessfull");
        System.out.println("Navigation to account page is sucessfull");
    }


    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
