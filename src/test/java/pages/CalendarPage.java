package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage {

    WebDriver driver;

    By calendarTitle = By.id("calendarTitle");
    By calendarText = By.id("calendarText");

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCalendarPageDisplayed() {
        return driver.findElement(calendarTitle).isDisplayed();
    }

    public boolean isCalendarMessageDisplayed() {
        return driver.findElement(calendarText).isDisplayed();
    }

    public String getCalendarTitleText() {
        return driver.findElement(calendarTitle).getText();
    }
}