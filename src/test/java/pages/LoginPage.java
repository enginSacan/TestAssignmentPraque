package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by mehmet engin sacan on 08.07.2019.
 */
public class LoginPage {
    WebDriver driver;
    String pageUrl = "https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getPage() {
        driver.get(pageUrl);
    }

    public void loginWithEmptyFields() {
        driver.findElement(By.id("sgnBt")).click();
    }

    public void login(String userName,String password) {
        driver.findElement(By.id("userid")).sendKeys(userName);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("sgnBt")).click();
    }

    public boolean isLoginSuccessful() {
        List<WebElement> errorMessage = driver.findElements(By.id("errf"));
        if (errorMessage.size() != 0) {
            return false;
        } else {
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("form-title")));
            if (driver.findElement(By.id("form-title")).isDisplayed()) {
                return false;
            }

        }
        return true;
    }

}

