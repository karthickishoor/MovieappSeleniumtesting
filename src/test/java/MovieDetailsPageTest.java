import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MovieDetailsPage;
import pages.PopularPage;

public class MovieDetailsPageTest {
    public WebDriver driver;
    public MovieDetailsPage moviedetailpage;
    public PopularPage popularpage;
    public int moviescount=0;
    public Actions action;


    @BeforeMethod
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\IntelJAutomation\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        moviedetailpage = new MovieDetailsPage(driver);
        popularpage=new PopularPage(driver);
        moviedetailpage.getvalidCredintials("rahul", "rahul@2021");
        driver.manage().window().maximize();
        action= new Actions(driver);
    }

    @Test
    public void checkthemoviedetailscontainer(){
        moviedetailpage.getmoviedetsils().click();

        String expectedmovietittle = "Shang-Chi and the Legend of the Ten Rings";
        String actualdmovietittle = moviedetailpage.getmoviedetailpagetittle().getText();

        Assert.assertEquals(actualdmovietittle,expectedmovietittle,"Movie tittle name is incorrect in movies detail page");
        System.out.println("Movie tittle name is incorrect in movies detail page");

        boolean expectedresult = true;

        Assert.assertEquals(moviedetailpage.getmoviedetailplaybutton().isDisplayed(),expectedresult,"Movie play button is not displayed in movies detail page");
        System.out.println("Movie play button is displayed in movies detail page");

        Assert.assertEquals(moviedetailpage.getmoviewatchtime().isDisplayed(),expectedresult,"Movie Watchtime is not displayed in movies detail page");
        System.out.println("Movie  Watchtime is displayed in movies detail page");

        Assert.assertEquals(moviedetailpage.getmsensorratingEl().isDisplayed(),expectedresult,"Movie  sensor rating is not displayed in movies detail page");
        System.out.println("Movie sensor rating is displayed in movies detail page");

        Assert.assertEquals(moviedetailpage.getreleaseyearEl().isDisplayed(),expectedresult,"Movie released year is not displayed in movies detail page");
        System.out.println("Movie released year is displayed in movies detail page");

        Assert.assertEquals(moviedetailpage.getmovieoverviewEl().isDisplayed(),expectedresult,"Movie over view is not displayed in movies detail page");
        System.out.println("Movie  over view  is displayed in movies detail page");

        boolean actualimg = moviedetailpage.getmediumscreenmoviecontainer().startsWith("url");

        Assert.assertEquals(actualimg,expectedresult,"Movie image is not displayed in movies detail page");
        System.out.println("Movie  image  is displayed in movies detail page");

        System.out.println("---------------------Popular session test------------------------------");

        popularpage.getnavbarlistitems().get(1).click();
        popularpage.getallthemovieslistedonpupularmoviespage().get(0).click();

        Assert.assertEquals(moviedetailpage.getmoviedetailplaybutton().isDisplayed(),expectedresult,"Movie play button is not displayed in movies detail page");
        System.out.println("Movie play button is displayed in movies detail page");

        Assert.assertEquals(moviedetailpage.getmoviewatchtime().isDisplayed(),expectedresult,"Movie Watchtime is not displayed in movies detail page");
        System.out.println("Movie  Watchtime is displayed in movies detail page");

        Assert.assertEquals(moviedetailpage.getmsensorratingEl().isDisplayed(),expectedresult,"Movie  sensor rating is not displayed in movies detail page");
        System.out.println("Movie sensor rating is displayed in movies detail page");

        Assert.assertEquals(moviedetailpage.getreleaseyearEl().isDisplayed(),expectedresult,"Movie released year is not displayed in movies detail page");
        System.out.println("Movie released year is displayed in movies detail page");

        Assert.assertEquals(moviedetailpage.getmovieoverviewEl().isDisplayed(),expectedresult,"Movie over view is not displayed in movies detail page");
        System.out.println("Movie  over view  is displayed in movies detail page");

        boolean actualimginpopularsestion = moviedetailpage.getmediumscreenmoviecontainer().startsWith("url");

        Assert.assertEquals(actualimginpopularsestion,expectedresult,"Movie image is not displayed in movies detail page");
        System.out.println("Movie  image  is displayed in movies detail page");


    }

    @AfterMethod
    public void Teardown(){
        driver.close();
    }

}
