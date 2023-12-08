import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;

public class AccountPageTest {
    public WebDriver driver;
    public AccountPage accountPage;
    public Actions action;


    @BeforeMethod
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\IntelJAutomation\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        accountPage = new AccountPage(driver);
        accountPage.getvalidCredintials("rahul", "rahul@2021");
        driver.manage().window().maximize();
        action= new Actions(driver);
    }

    @Test
    public void checkaccountpageUI(){
        accountPage.getaccountspage().click();

        String expectedaccountpageheadingtext = "Account";
        String actualaccountpageheadingtext = accountPage.getaccountheading().getText();
        Assert.assertEquals(expectedaccountpageheadingtext,actualaccountpageheadingtext,"Account page heading do not match");
        System.out.println("Account page heading match");

        String expectedaccountpagemembershipheadingtext = "Member ship";
        String actualaccountpagemembershipheadingtext = accountPage.getmembership().getText();
        Assert.assertEquals(expectedaccountpagemembershipheadingtext,actualaccountpagemembershipheadingtext,"Account page membership heading do not match");
        System.out.println("Account page membership heading match");

        String expectedaccountpageusernameheadingtext = "User name : rahul";
        String actualaccountpageusernameheadingtext = accountPage.getmembershipusernameheading().getText();
        Assert.assertEquals(expectedaccountpageusernameheadingtext,actualaccountpageusernameheadingtext,"Account page User name heading do not match");
        System.out.println("Account page User name heading match");

        String expectedaccountpagepasswordheadingtext = "Password : **********";
        String actualaccountpagepasswordheadingtext = accountPage.getmembershippasswordheading().getText();
        Assert.assertEquals(expectedaccountpagepasswordheadingtext,actualaccountpagepasswordheadingtext,"Account page password heading do not match");
        System.out.println("Account page password heading match");

        String expectedaccountpageplandetailheadingtext = "Plan details";
        String actualaccountpageplandetailheadingtext = accountPage.getPlandetails().getText();
        Assert.assertEquals(expectedaccountpageplandetailheadingtext,actualaccountpageplandetailheadingtext,"Account page plan detail heading do not match");
        System.out.println("Account page plan detail heading match");

        String expectedaccountpageplanparatext = "Premium";
        String actualaccountpageplanparatext = accountPage.getplanparagraph().getText();
        Assert.assertEquals(expectedaccountpageplanparatext,actualaccountpageplanparatext,"Account page plan paragraph do not match");
        System.out.println("Account page plan paragraph match");

        String expectedaccountpageplanparadetailtext = "Ultra HD";
        String actualaccountpageplanparadetailtext = accountPage.getplandetails().getText();
        Assert.assertEquals(expectedaccountpageplanparadetailtext,actualaccountpageplanparadetailtext,"Account page plan paragraph detail do not match");
        System.out.println("Account page plan paragraph detail match");

    }
}
