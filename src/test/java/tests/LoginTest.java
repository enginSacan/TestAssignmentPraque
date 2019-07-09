package tests;

import static org.junit.Assert.assertFalse;


import org.junit.Test;
import pages.LoginPage;
import utils.TestAbstract;

/**
 * Created by mehmet engin sacan on 08.07.2019.
 */
public class LoginTest extends TestAbstract {
    @Test
    public void LoginAttemptWithEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getPage();
        loginPage.loginWithEmptyFields();
        assertFalse(loginPage.isLoginSuccessful());
    }

    @Test
    public void LoginAttemptWithDummyVariables() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getPage();
        loginPage.login("asdasd","adsasd");
        assertFalse(loginPage.isLoginSuccessful());
    }

}
