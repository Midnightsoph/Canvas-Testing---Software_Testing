package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileSettingsTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        driver.get(loginPageUrl);
        new LoginPage(driver).login("student@test.com", "test123");
        pause(2);
        driver.get(profileUrl);
    }

    @Test
    public void verifyProfileDisplayed() {
        Assert.assertTrue(new ProfilePage(driver).isProfilePageDisplayed());
    }

    @Test
    public void verifyProfileNameDisplayed() {
        Assert.assertTrue(new ProfilePage(driver).isProfileNameDisplayed());
    }

    @Test
    public void verifyProfileEmailDisplayed() {
        Assert.assertTrue(new ProfilePage(driver).isProfileEmailDisplayed());
    }

    @Test
    public void verifyUpdateProfile() {
        ProfilePage page = new ProfilePage(driver);
        page.editName("Alex Johnson");
        page.editEmail("alex@test.com");
        page.editMajor("Software Engineering");
        page.clickSaveProfile();
        Assert.assertEquals(page.getProfileStatus(), "Profile updated successfully.");
    }

    @Test
    public void verifyEmptyProfileError() {
        ProfilePage page = new ProfilePage(driver);
        page.editName("");
        page.editEmail("");
        page.editMajor("");
        page.clickSaveProfile();
        Assert.assertEquals(page.getProfileStatus(), "Please complete all profile fields.");
    }
}