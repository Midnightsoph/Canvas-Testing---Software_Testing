package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage {

    WebDriver driver;

    By calendarTitle = By.id("calendarTitle");
    By calendarText = By.id("calendarText");
    By calendarEventInput = By.id("calendarEventInput");
    By addCalendarEventButton = By.id("addCalendarEventButton");
    By markImportantButton = By.id("markImportantButton");
    By removeLastEventButton = By.id("removeLastEventButton");
    By clearCalendarButton = By.id("clearCalendarButton");
    By calendarStatus = By.id("calendarStatus");
    By calendarEventList = By.id("calendarEventList");

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCalendarPageDisplayed() {
        return driver.findElement(calendarTitle).isDisplayed();
    }

    public boolean isCalendarMessageDisplayed() {
        return driver.findElement(calendarText).isDisplayed();
    }

    public void enterCalendarEvent(String event) {
        driver.findElement(calendarEventInput).clear();
        driver.findElement(calendarEventInput).sendKeys(event);
    }

    public void clickAddCalendarEvent() {
        driver.findElement(addCalendarEventButton).click();
    }

    public void clickMarkImportant() {
        driver.findElement(markImportantButton).click();
    }

    public void clickRemoveLastEvent() {
        driver.findElement(removeLastEventButton).click();
    }

    public void clickClearCalendarEvents() {
        driver.findElement(clearCalendarButton).click();
    }

    public String getCalendarStatus() {
        return driver.findElement(calendarStatus).getText();
    }

    public String getCalendarEventListText() {
        return driver.findElement(calendarEventList).getText();
    }
}