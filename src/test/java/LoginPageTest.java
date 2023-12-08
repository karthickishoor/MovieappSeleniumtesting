import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest {

    public WebDriver driver;
    public LoginPage loginpage;

    @BeforeMethod
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\IntelJAutomation\\chromedriver\\chromedriver.exe" );
        driver=new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginpage = new LoginPage(driver);
    }

    //Login page Logo check
    @Test
    public void checkwebsiteloginpageUI() {
        Assert.assertTrue(loginpage.getwebsitelogo().isDisplayed(), "Loginpage Logo is not displayed");
        System.out.println("Loginpage Logo is displayed");


    //Loginpage headingcheck

        String loginpageheading = loginpage.getwebsiteloginheading().getText();
        String expectedloginpageheading = "Login";
        Assert.assertEquals(loginpageheading, expectedloginpageheading, "Loginpage heading do not match");
        System.out.println("Loginpage heading match");


    //Loginpage labels check


        String usernamelabel = loginpage.getlabelofusername().getText();
        String expectedusernamelabel = "USERNAME";
        Assert.assertEquals(usernamelabel, expectedusernamelabel, "username label do not match");
        System.out.println("username label match");
        String passwordlabel = loginpage.getlabelofpassword().getText();
        String expectedpasswordlabel = "PASSWORD";
        Assert.assertEquals(passwordlabel, expectedpasswordlabel, "password label do not match");
        System.out.println("password label match");

    //Loginpage Login button check

        loginpage.getloginbutton().click();
        Assert.assertTrue(loginpage.getloginbutton().isEnabled(),"Login button is not enabled");
        System.out.println("Login button is enabled");
    }
    //@DataProvider
    //public Object[][] logindata(){
    //    return new Object[][]{
    //            {"", ""},
    //            {"","rahul@2021"},
    //            {"rahul",""},
      //          {"rahul","rahul@2021"}
     //   };
   // }

   // @Test(priority = 2 , dataProvider = "logindata")
   // public void  LoginPageFunctionalities(String username, String password){
    //    loginpage.clickonloginbutton(username,password);
   // }
    @Test
    public void Loginwithtestwithdiffrentcredentials(){
            loginpage.getusernameinput().sendKeys("");
            loginpage.getpasswordinput().sendKeys("");
            loginpage.clickonloginbutton();
            loginpage.cleartheinputfileds();

            loginpage.getusernameinput().sendKeys("");
            loginpage.getpasswordinput().sendKeys("rahul@2021");
            loginpage.clickonloginbutton();
            loginpage.cleartheinputfileds();

            loginpage.getusernameinput().sendKeys("rahul");
            loginpage.getpasswordinput().sendKeys("");
            loginpage.clickonloginbutton();
            loginpage.cleartheinputfileds();

            loginpage.getusernameinput().sendKeys("rahul");
            loginpage.getpasswordinput().sendKeys("rahul@2021");
            loginpage.clickonloginbutton();

    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }



}
