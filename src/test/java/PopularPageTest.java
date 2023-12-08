import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PopularPage;

public class PopularPageTest {
    public WebDriver driver;
    public PopularPage popularpage;


    @BeforeMethod
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\IntelJAutomation\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        popularpage = new PopularPage(driver);
        popularpage.getvalidCredintials("rahul", "rahul@2021");
        driver.manage().window().maximize();
    }

    @Test
    public void checkallthemovieslistedinpopularmoviespage(){
        popularpage.getnavbarlistitems().get(1).click();
        for(WebElement movieslist : popularpage.getallthemovieslistedonpupularmoviespage())
        {
            Assert.assertEquals(movieslist.isDisplayed(),true,"Popular Movies are not displayed");
            System.out.println("Popular Movies are displayed");
        }

    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }

}
