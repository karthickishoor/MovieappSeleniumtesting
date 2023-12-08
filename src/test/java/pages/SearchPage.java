package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class SearchPage {
    By usernameInputEl = By.id("usernameInput");
    By passwordInputEl =By.id("passwordInput");
    By loginbuttonEl = By.className("login-button");
    By searchbuttonEl = By.xpath("//button[@type='button']");
    //By searchinputel = By.id("search");
    By searchiputvalueel = By.id("search");
    By movieslistafterserach = By.xpath("//ul[@class='search-movies-container']/child::li");


    WebDriver driver;
    WebDriverWait wait;


    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    public void getvalidCredintials(String username, String password){
        driver.findElement(usernameInputEl).sendKeys(username);
        driver.findElement(passwordInputEl).sendKeys(password);
        driver.findElement(loginbuttonEl).click();
    }

    public WebElement getserachbutton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchbuttonEl));
        return driver.findElement(searchbuttonEl);
    }

    public WebElement getmoviename(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchiputvalueel));
        return  driver.findElement(searchiputvalueel);
    }

    public List<WebElement> getmovieslisted(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieslistafterserach));
        return driver.findElements(movieslistafterserach);
    }


}
