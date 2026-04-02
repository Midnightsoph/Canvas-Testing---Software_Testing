package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxPage {

    WebDriver driver;

    By inboxTitle = By.id("inboxTitle");
    By inboxList = By.id("inboxList");

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
}
