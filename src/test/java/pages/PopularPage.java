package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopularPage {
    By usernameInputEl = By.id("usernameInput");
    By passwordInputEl =By.id("passwordInput");
    By loginbuttonEl = By.className("login-button");
    By searchmoviescontainer = By.xpath("//div[@class='search-movies-container']/child::li");
    By navbarlistitems = By.xpath("//div[@class='nav-content']/child::ul/child::*");

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public PopularPage(WebDriver driver){
        this.driver = driver;
        this.actions= new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void getvalidCredintials(String username, String password){
        driver.findElement(usernameInputEl).sendKeys(username);
        driver.findElement(passwordInputEl).sendKeys(password);
        driver.findElement(loginbuttonEl).click();
    }

    public List<WebElement> getnavbarlistitems(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navbarlistitems));
        return driver.findElements(navbarlistitems);
    }

    public List<WebElement> getallthemovieslistedonpupularmoviespage() {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchmoviescontainer));
            return driver.findElements(searchmoviescontainer);

    }
}
