package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void verifyLoginPageLoads() {
        Assert.assertTrue(driver.getTitle().contains("Login"));
    }

    @Test
    public void verifyEmailFieldIsDisplayed() {
        LoginPage page = new LoginPage(driver);
        Assert.assertTrue(page.isEmailFieldDisplayed());
    }

    @Test
    public void verifyPasswordFieldIsDisplayed() {
        LoginPage page = new LoginPage(driver);
        Assert.assertTrue(page.isPasswordFieldDisplayed());
    }

    @Test
    public void verifyLoginButtonIsDisplayed() {
        LoginPage page = new LoginPage(driver);
        Assert.assertTrue(page.isLoginButtonDisplayed());
    }

    @Test
    public void verifyValidLogin() {
        LoginPage page = new LoginPage(driver);
        page.login("student@test.com", "test123");
        pause(2);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard.html"));
    }

    @Test
    public void verifyInvalidLoginShowsError() {
        LoginPage page = new LoginPage(driver);
        page.login("wrong@test.com", "wrong123");
        pause(1);
        Assert.assertEquals(page.getErrorMessage(), "Invalid email or password.");
    }

    @Test
    public void verifyEmptyEmailShowsError() {
        LoginPage page = new LoginPage(driver);
        page.login("", "test123");
        pause(1);
        Assert.assertEquals(page.getErrorMessage(), "Invalid email or password.");
    }

    @Test
    public void verifyEmptyPasswordShowsError() {
        LoginPage page = new LoginPage(driver);
        page.login("student@test.com", "");
        pause(1);
        Assert.assertEquals(page.getErrorMessage(), "Invalid email or password.");
    }
}