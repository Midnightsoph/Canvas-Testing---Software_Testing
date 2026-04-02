package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;

public class InboxTests extends BaseTest {

    @BeforeMethod
    public void loginAndOpenInbox() {
        driver.get(loginPageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "test123");
        pause(3);
        driver.get(inboxUrl);
        pause(3);
    }

    @Test
    public void verifyInboxPageIsDisplayed() {
        InboxPage inboxPage = new InboxPage(driver);
        Assert.assertTrue(inboxPage.isInboxPageDisplayed());
    }

    @Test
    public void verifyMessagesAreDisplayed() {
        InboxPage inboxPage = new InboxPage(driver);
        Assert.assertTrue(inboxPage.areMessagesDisplayed());
    }
    @Test
    public void verifyInboxContainsProfessorMessage() {
        InboxPage inboxPage = new InboxPage(driver);
        Assert.assertTrue(inboxPage.getInboxText().contains("Professor"));
    }
}
