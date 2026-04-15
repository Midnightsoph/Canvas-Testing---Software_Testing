package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxPage {

    WebDriver driver;

    By inboxTitle = By.id("inboxTitle");
    By inboxList = By.id("inboxList");
    By recipientInput = By.id("recipientInput");
    By subjectInput = By.id("subjectInput");
    By messageInput = By.id("messageInput");
    By sendMessageButton = By.id("sendMessageButton");
    By saveDraftButton = By.id("saveDraftButton");
    By clearMessageButton = By.id("clearMessageButton");
    By sendMessageStatus = By.id("sendMessageStatus");

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInboxPageDisplayed() {
        return driver.findElement(inboxTitle).isDisplayed();
    }

    public boolean areMessagesDisplayed() {
        return driver.findElement(inboxList).getText().length() > 0;
    }

    public String getInboxText() {
        return driver.findElement(inboxList).getText();
    }

    public void enterRecipient(String recipient) {
        driver.findElement(recipientInput).clear();
        driver.findElement(recipientInput).sendKeys(recipient);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectInput).clear();
        driver.findElement(subjectInput).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageInput).clear();
        driver.findElement(messageInput).sendKeys(message);
    }

    public void clickSendMessage() {
        driver.findElement(sendMessageButton).click();
    }

    public void clickSaveDraft() {
        driver.findElement(saveDraftButton).click();
    }

    public void clickClearMessageForm() {
        driver.findElement(clearMessageButton).click();
    }

    public String getSendMessageStatus() {
        return driver.findElement(sendMessageStatus).getText();
    }
}