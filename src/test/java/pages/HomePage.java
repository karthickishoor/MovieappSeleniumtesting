package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import javax.swing.plaf.basic.BasicSliderUI;
import java.security.PublicKey;
import java.time.Duration;
import java.util.List;



public class HomePage {

    By usernameInputEl = By.id("usernameInput");
    By passwordInputEl =By.id("passwordInput");
    By loginbuttonEl = By.className("login-button");
    By homepagecontainerEl = By.className("home-container");
    By homepageheadingEl = By.className("movies-list-heading");
    By homepagemovieplaybutton = By.className("home-movie-play-button");
    By alltrendingMoviesimg = By.xpath("//h1[text()='Trending Now']/following-sibling::div//img");
    By allOriginalsMoviesimg = By.xpath("//h1[text()='Originals']/following-sibling::div//img");
    By nextscrollarrowbutton = By.xpath("//h1[text()='Trending Now']/following-sibling::*/child::*/button[text()='Next']");
    By contactusparagraphsession= By.className("contact-us-paragraph");


    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    public void getvalidCredintials(String username, String password){
        driver.findElement(usernameInputEl).sendKeys(username);
        driver.findElement(passwordInputEl).sendKeys(password);
        driver.findElement(loginbuttonEl).click();
    }


    public List<WebElement> getheadingsforallsectionsinhomepage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homepagecontainerEl));
        return driver.findElements(homepageheadingEl);
    }

    public WebElement getplaybuttoninhomepage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homepagemovieplaybutton));
        return driver.findElement(homepagemovieplaybutton);
    }

    public List<WebElement> getalltrendingmovieimghomepage(){
        //List<WebElement> alltredingmovies = driver.findElements(alltrendingMoviesimg);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nextscrollarrowbutton));
        return  driver.findElements(alltrendingMoviesimg);
    }

    public List<WebElement> getalloriginalgmovieimghomepage(){
        //List<WebElement> alltredingmovies = driver.findElements(alltrendingMoviesimg);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nextscrollarrowbutton));
        return  driver.findElements(allOriginalsMoviesimg);
    }
    //public WebElement getthenextscrollarrowbutton (){
    //    return driver.findElement(nextscrollarrowbutton);
   // }

    public String getcontactustext(){
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactusparagraphsession));
        return driver.findElement(contactusparagraphsession).getText();
    }



}
