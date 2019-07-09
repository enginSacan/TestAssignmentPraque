package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by mehmet engin sacan on 08.07.2019.
 */
public class HomePage {
    WebDriver driver;
    String pageUrl = "https://www.ebay.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void getPage() {
        driver.get(pageUrl);
    }

    public void searchProduct(String productName) {
        driver.findElement(By.id("gh-ac")).sendKeys(productName);
        driver.findElement(By.id("gh-btn")).click();
    }
    public void selectOneProduct (int selectedItemIndex) {
        List<WebElement> products = driver.findElements(By.xpath("//a[contains(@href,'Apple') and @class='s-item__link']"));
        products.get(selectedItemIndex).click();
    }
    public boolean isCorrectProductDisplayed(String searchedProduct) {

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(@href,'Apple') and @class='s-item__link']")));
        List<WebElement> products = driver.findElements(By.xpath("//a[contains(@href,'Apple') and @class='s-item__link']"));

        for (WebElement product : products) {
            if (!product.getText().contains(searchedProduct)) {
                return false;
            }
        }
        return true;
    }
    public boolean isHoverMenuAppeared () {

        try {

            List<WebElement> hoverMenus = driver.findElements(By.xpath("//li[@class='hl-cat-nav__js-tab']"));
            Actions hoverMenuAction = new Actions(driver);

            for (WebElement hoverMenu : hoverMenus) {

                hoverMenuAction.moveToElement(hoverMenu).perform();

                new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@class='hl-cat-nav__sub-cat-col']")));

                if (!driver.findElement(By.xpath("//div[@class='hl-cat-nav__sub-cat-col']")).isDisplayed()) {
                    return false;
                }
            }

        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
