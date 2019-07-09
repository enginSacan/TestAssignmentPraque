package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by mehmet engin sacan on 08.07.2019.
 */
public class ProductPage extends HomePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean excludeCountriesCouldNotBeListed (){
        driver.findElement(By.xpath("//a[@class='vhr-tab-itm' and @aria-controls='shipping_panel']")).click();
        String excludedCountries = driver.findElement(By.xpath("//div [@class='sh-sLoc'][2]")).getText();

        String [] cleanCountries = excludedCountries.split(":");
        excludedCountries = cleanCountries[1];
        cleanCountries = excludedCountries.split(",");

        Select countries = new Select(driver.findElement(By.id("shCountry")));
        List<WebElement> countryOptions = countries.getOptions();


        //   Checking dropdown menu items could not be in exclude countries.

        for (WebElement countryOption : countryOptions) {
            String dropdownCountry = countryOption.getText();
            for (String country : cleanCountries) {
                if (country.equals(dropdownCountry)){
                    return false;
                }
            }
        }



        return true;
    }
}
