package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;

public class InboxTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        driver.get(loginPageUrl);
        new LoginPage(driver).login("student@test.com", "test123");
        pause(3);
        driver.get(inboxUrl);
        pause(3);
    }

    @Test
    public void verifyInboxDisplayed() {
        Assert.assertTrue(new InboxPage(driver).isInboxPageDisplayed());
        pause(3);
    }

    @Test
    public void verifyInboxContainsProfessorSmithMessage() {
        Assert.assertTrue(new InboxPage(driver).getInboxText().contains("Professor Smith"));
        pause(3);
    }

    @Test
    public void verifyUserCanSendFinalProjectMessage() {
        InboxPage page = new InboxPage(driver);

        page.enterRecipient("Professor Smith");
        pause(3);

        page.enterSubject("Final Project");
        pause(3);

        page.enterMessage("This is a turned in project.");
        pause(3);

        page.clickSendMessage();
        pause(3);

        Assert.assertEquals(page.getSendMessageStatus(), "Message sent successfully.");
    }

    @Test
    public void verifyUserCanSaveDraftMessage() {
        InboxPage page = new InboxPage(driver);

        page.enterRecipient("Professor Smith");
        pause(3);

        page.enterSubject("Final Project");
        pause(3);

        page.enterMessage("This is a turned in project.");
        pause(3);

        page.clickSaveDraft();
        pause(3);

        Assert.assertEquals(page.getSendMessageStatus(), "Draft saved successfully.");
    }

    @Test
    public void verifyUserCanClearMessageForm() {
        InboxPage page = new InboxPage(driver);

        page.enterRecipient("Professor Smith");
        pause(3);

        page.enterSubject("Final Project");
        pause(3);

        page.enterMessage("This is a turned in project.");
        pause(3);

        page.clickClearMessageForm();
        pause(3);

        Assert.assertEquals(page.getSendMessageStatus(), "Message form cleared.");
    }
}