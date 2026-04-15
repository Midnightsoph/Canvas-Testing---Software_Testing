package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.LoginPage;

public class CalendarTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        driver.get(loginPageUrl);
        new LoginPage(driver).login("student@test.com", "test123");
        pause(3);
        driver.get(calendarUrl);
        pause(3);
    }

    @Test
    public void verifyCalendarDisplayed() {
        Assert.assertTrue(new CalendarPage(driver).isCalendarPageDisplayed());
    }

    @Test
    public void verifyUserCanAddEvent() {
        CalendarPage page = new CalendarPage(driver);
        page.enterCalendarEvent("Capstone Presentation");
        page.clickAddCalendarEvent();
        pause(2);
        Assert.assertEquals(page.getCalendarStatus(), "Event added successfully.");
    }

    @Test
    public void verifyAddedEventAppearsInList() {
        CalendarPage page = new CalendarPage(driver);
        page.enterCalendarEvent("Capstone Presentation");
        page.clickAddCalendarEvent();
        pause(2);
        Assert.assertTrue(page.getCalendarEventListText().contains("Capstone Presentation"));
    }

    @Test
    public void verifyUserCanMarkLastEventImportant() {
        CalendarPage page = new CalendarPage(driver);
        page.enterCalendarEvent("Internship Interview");
        page.clickAddCalendarEvent();
        pause(2);
        page.clickMarkImportant();
        pause(2);
        Assert.assertTrue(page.getCalendarEventListText().contains("Important: Internship Interview"));
    }

    @Test
    public void verifyUserCanRemoveLastEvent() {
        CalendarPage page = new CalendarPage(driver);
        page.enterCalendarEvent("Practice Demo");
        page.clickAddCalendarEvent();
        pause(2);
        page.clickRemoveLastEvent();
        pause(2);
        Assert.assertEquals(page.getCalendarStatus(), "Last event removed.");
    }
}