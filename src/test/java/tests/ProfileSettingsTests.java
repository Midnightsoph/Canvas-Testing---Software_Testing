package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileSettingsTests extends BaseTest {

    @BeforeMethod
    public void loginAndOpenProfile() {
        driver.get(loginPageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "test123");
        pause(3);
        driver.get(profileUrl);
        pause(3);
    }

    @Test
    public void verifyProfilePageIsDisplayed() {
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isProfilePageDisplayed());
    }

    @Test
    public void verifyProfileNameIsDisplayed() {
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isProfileNameDisplayed());
    }

    @Test
    public void verifyProfileEmailIsDisplayed() {
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isProfileEmailDisplayed());
    }

    @Test
    public void verifyProfileEmailTextIsCorrect() {
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertEquals(profilePage.getProfileEmailText(), "Email: student@test.com");
    }

    @Test
    public void verifyProfilePageUrl() {
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        Assert.assertTrue(currentUrl.contains("profile"), "URL should contain 'profile'");
    }
}