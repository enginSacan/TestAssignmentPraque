package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by mehmet engin sacan on 08.07.2019.
 */
public class TestAbstract {
    protected static WebDriver driver;


    @BeforeClass
    public static void openWebsite() {
        /**
            For browser drivers, you need to add driver addresses to the path in the pc (I already added)
            otherwise driver class could not open browser.

            If you do not want to add variables in path, you can add code below for drivers:

            System.setProperty("webdriver.gecko.driver","path_of_driver_exe");

         */
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeWebsite(){
        driver.quit();
    }
}

