package tests;

import org.junit.Test;
import pages.HomePage;
import utils.TestAbstract;

import static junit.framework.TestCase.assertTrue;

public class HoverMenuTest extends TestAbstract {
    @Test
    public void hoverMenuLook() {
        HomePage homePage = new HomePage(driver);
        homePage.getPage();
        assertTrue(homePage.isHoverMenuAppeared());
    }
}
