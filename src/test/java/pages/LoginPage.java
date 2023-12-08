package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    By usernameInputlabelEl = By.xpath("//label[text() ='USERNAME' ]");
    By usernameInputEl = By.id("usernameInput");

    By passwordInputlabelEl = By.xpath("//label[text() ='PASSWORD' ]");
    By passwordInputEl =By.id("passwordInput");

    By loginwebsitelogoEl = By.className("login-website-logo");
    By signinheadingEl = By.className("sign-in-heading");
    By loginbuttonEl = By.cssSelector(".login-button");

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //Loginpage UI check webelements----------------------------------------------------------------------------------
    public WebElement getwebsitelogo(){
         return driver.findElement(loginwebsitelogoEl);

    }
    public WebElement getwebsiteloginheading(){
        return driver.findElement(signinheadingEl);
    }
    public WebElement getlabelofusername(){
        return driver.findElement(usernameInputlabelEl);

    }
    public WebElement getlabelofpassword(){
        return driver.findElement(passwordInputlabelEl);
    }
    public WebElement getloginbutton(){
        return driver.findElement(loginbuttonEl);
    }

    //Loginpage Functionality check-----------------------------------------------------------------------------------
    public  WebElement getusernameinput(){
        return driver.findElement(usernameInputEl);
    }
    public  WebElement getpasswordinput(){
        return driver.findElement(passwordInputEl);
    }

    public void clickonloginbutton(){
        getloginbutton().click();

    }

    public void cleartheinputfileds(){
        getpasswordinput().clear();
        getpasswordinput().clear();
    }


}
