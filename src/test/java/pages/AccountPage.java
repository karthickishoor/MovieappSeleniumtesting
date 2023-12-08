package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    By usernameInputEl = By.id("usernameInput");
    By passwordInputEl =By.id("passwordInput");
    By loginbuttonEl = By.className("login-button");
    By accountavatar = By.className("avatar-button");
    By accountheadingEl = By.className("account-heading");
    By MembershipEl = By.xpath("//p[text()='Member ship']");//Plan details
    By membershipusernameEl = By.className("membership-username");
    By membershippasswordEl = By.className("membership-password");
    By PlandetailsEl = By.xpath("//p[text()='Plan details']");
    By planparagraphEl = By.className("plan-paragraph");
    By plandetailsEl = By.className("plan-details");
    By logoutbuttonEl = By.className("logout-button");




    WebDriver driver;
    WebDriverWait wait;


    public AccountPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    public void getvalidCredintials(String username, String password){
        driver.findElement(usernameInputEl).sendKeys(username);
        driver.findElement(passwordInputEl).sendKeys(password);
        driver.findElement(loginbuttonEl).click();
    }

    public WebElement getaccountspage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountavatar));
        return driver.findElement(accountavatar);
    }
    public WebElement getmembershipusernameheading(){
        return driver.findElement(membershipusernameEl);
    }
    public WebElement getmembershippasswordheading(){
        return driver.findElement(membershippasswordEl);
    }
    public WebElement getaccountheading(){
        return driver.findElement(accountheadingEl);
    }
    public WebElement getmembership(){
        return driver.findElement(MembershipEl);
    }
    public WebElement getPlandetails(){
        return driver.findElement(PlandetailsEl);
    }
    public WebElement getplanparagraph(){
        return driver.findElement(planparagraphEl);
    }
    public WebElement getplandetails(){
        return driver.findElement(plandetailsEl);
    }
    public WebElement getlogoutbutton(){
        return driver.findElement(logoutbuttonEl);
    }
}
