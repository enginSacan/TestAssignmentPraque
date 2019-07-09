package tests;

import org.junit.Test;

import pages.ProductPage;
import utils.TestAbstract;

import static junit.framework.TestCase.assertTrue;
/**
 * Created by mehmet engin sacan on 08.07.2019.
 */
public class ExcludeCountryTest extends TestAbstract {
    @Test
    public void countryListWithoutExcludes() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getPage();
        productPage.searchProduct("Apple");
        productPage.selectOneProduct(3);
        assertTrue(productPage.excludeCountriesCouldNotBeListed());
    }
}
