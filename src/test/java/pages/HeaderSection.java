package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HeaderSection {
    By usernameInputEl = By.id("usernameInput");
    By passwordInputEl =By.id("passwordInput");
    By loginbuttonEl = By.className("login-button");
    By websitelogoofnavbarEl = By.className("website-logo");
    By navbarlistitems = By.xpath("//div[@class='nav-content']/child::ul/child::*");
    By navbarsearchemptybutton = By.cssSelector(".search-empty-button");
    By homemoviedetailscontainer = By.className("home-movie-details-container");
    By accountavatarbutton = By.className("avatar-button");
    By accountheadinginaccountpage = By.className("account-heading");



    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public HeaderSection(WebDriver driver){
        this.driver = driver;
        this.actions= new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    public void getvalidCredintials(String username, String password){
        driver.findElement(usernameInputEl).sendKeys(username);
        driver.findElement(passwordInputEl).sendKeys(password);
        driver.findElement(loginbuttonEl).click();
    }

    public WebElement  getwebsitelogoofnavbar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(websitelogoofnavbarEl));
        return  driver.findElement(websitelogoofnavbarEl);
    }

    public List<WebElement> getnavbarlistitems(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navbarlistitems));
        return driver.findElements(navbarlistitems);
    }

    public WebElement getnavbarsearchemptybutton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navbarsearchemptybutton));
        return driver.findElement(navbarsearchemptybutton);
    }

    public WebElement gettohomepagenavitem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homemoviedetailscontainer));
        return driver.findElement(homemoviedetailscontainer);
    }


    public WebElement getbuttonofaccountpage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountavatarbutton));
        return driver.findElement(accountavatarbutton);
    }

    public WebElement getaccountpageheading(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountheadinginaccountpage));
        return driver.findElement(accountheadinginaccountpage);
    }

}
