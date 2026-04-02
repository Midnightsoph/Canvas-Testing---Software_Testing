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
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isEmailFieldDisplayed());
    }

    @Test
    public void verifyPasswordFieldIsDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
    }

    @Test
    public void verifyLoginButtonIsDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "test123");
        pause(2);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard.html"));
    }

    @Test
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong@test.com", "wrong123");
        pause(1);
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password.");
    }
    @Test
    public void verifyLoginPageUrlContainsLoginFile() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login.html"));
    }

    @Test
    public void verifyEmptyEmailAndPasswordShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        pause(1);
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password.");
    }

    @Test
    public void verifyEmptyEmailShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "test123");
        pause(1);
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password.");
    }

    @Test
    public void verifyEmptyPasswordShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "");
        pause(1);
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password.");
    }
}