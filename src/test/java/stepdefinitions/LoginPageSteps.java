package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginPageSteps {
    WebDriver driver = Hooks.getDriver();
    public LoginPage loginpage = new LoginPage(driver);

    @Given("I am on the login page")
    public void iAmOnTheLoginpage(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }

    @When("I enter valid username and password")
    public void iEntervalidUsernameAndPassword(){
        loginpage.getusernameinput().sendKeys("rahul");
        loginpage.getpasswordinput().sendKeys("rahul@2021");
        loginpage.clickonloginbutton();
    }

    @And("I click on login button")
    public void iClickOnLoginButton(){
        loginpage.getloginbutton().click();
    }

    @When("I enter Invalid username and I enter a valid password")
    public void IenterInvalidusernameandIenteravalidpassword(){
        loginpage.getusernameinput().sendKeys("");
        loginpage.getpasswordinput().sendKeys("rahul@2021");
    }

    @Then("I should be able see a error message")
    public void Ishouldbeableseeaerrormessage(){
        System.out.println("Invalid username and password");
    }

    @When("I enter valid username and I enter a Invalid password")
    public void IentervalidusernameandIenteraInvalidpassword(){
        loginpage.getusernameinput().sendKeys("rahul");
        loginpage.getpasswordinput().sendKeys("");
    }

    @When("I enter Invalid username and I enter a Invalid password")
    public void IenterInvalidusernameandIenteraInvalidpassword(){
        loginpage.getusernameinput().sendKeys("");
        loginpage.getpasswordinput().sendKeys("");
    }

    @Then("I should be able to redirected to the homepage")
    public void Ishouldbeabletoredirectedtothehomepage(){
        System.out.println("I was redirected");
    }

}
