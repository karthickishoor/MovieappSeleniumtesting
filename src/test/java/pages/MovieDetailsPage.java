package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MovieDetailsPage {
    By usernameInputEl = By.id("usernameInput");
    By passwordInputEl =By.id("passwordInput");
    By loginbuttonEl = By.className("login-button");
    By movieiconEl = By.xpath("//h1[text()='Trending Now']/following-sibling::div//img[@alt='Shang-Chi and the Legend of the Ten Rings']");
    By moviedetailpageheading = By.className("movie-title");
    By moviedetailpageplaybutton = By.className("play-button");
    //By movieslistafterserach = By.xpath("//ul[@class='search-movies-container']/child::li");
    By watchtimeEl = By.className("watch-time");
    By sensorratingEl = By.className("sensor-rating");
    By releaseyearEl = By.className("release-year");
    By movieoverviewEl = By.className("movie-overview");
    By mediumscreenmoviecontainer = By.className("medium-screen-movie-container");



    WebDriver driver;
    WebDriverWait wait;


    public MovieDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    public void getvalidCredintials(String username, String password){
        driver.findElement(usernameInputEl).sendKeys(username);
        driver.findElement(passwordInputEl).sendKeys(password);
        driver.findElement(loginbuttonEl).click();
    }

    public WebElement getmoviedetsils(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieiconEl));
        return driver.findElement(movieiconEl);
    }

    public WebElement getmoviedetailpagetittle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviedetailpageheading));
        return driver.findElement(moviedetailpageheading);
    }
    public WebElement getmoviedetailplaybutton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviedetailpageplaybutton));
        return driver.findElement(moviedetailpageplaybutton);
    }

    public WebElement getmoviewatchtime(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(watchtimeEl));
        return driver.findElement(watchtimeEl);
    }
    public WebElement getmsensorratingEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sensorratingEl));
        return driver.findElement(sensorratingEl);
    }
    public WebElement getreleaseyearEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseyearEl));
        return driver.findElement(releaseyearEl);
    }
    public WebElement getmovieoverviewEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieoverviewEl));
        return driver.findElement(movieoverviewEl);
    }
    public String getmediumscreenmoviecontainer(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mediumscreenmoviecontainer));
         WebElement backgroundimage= driver.findElement(mediumscreenmoviecontainer);
         return  backgroundimage.getCssValue("background-image");
    }

}
