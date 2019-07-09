package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import pages.HomePage;
import utils.TestAbstract;

/**
 * Created by mehmet engin sacan on 08.07.2019.
 */
public class SearchProductTest extends TestAbstract {
    @Test
    public void searchProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.getPage();
        homePage.searchProduct("Apple");
        assertTrue(homePage.isCorrectProductDisplayed("Apple"));
    }
}

