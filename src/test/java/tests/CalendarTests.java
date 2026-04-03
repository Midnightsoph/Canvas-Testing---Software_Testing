package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.LoginPage;

public class CalendarTests extends BaseTest {

    @BeforeMethod
    public void loginAndOpenCalendar() {
        driver.get(loginPageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "test123");
        pause(3);
        driver.get(calendarUrl);
        pause(3);
    }

    @Test
    public void verifyCalendarPageIsDisplayed() {
        CalendarPage calendarPage = new CalendarPage(driver);
        Assert.assertTrue(calendarPage.isCalendarPageDisplayed());
    }

    @Test
    public void verifyCalendarMessageIsDisplayed() {
        CalendarPage calendarPage = new CalendarPage(driver);
        Assert.assertTrue(calendarPage.isCalendarMessageDisplayed());
    }

    @Test
    public void verifyCalendarTitleTextIsCorrect() {
        CalendarPage calendarPage = new CalendarPage(driver);
        Assert.assertEquals(calendarPage.getCalendarTitleText(), "Calendar");
    }

    @Test
    public void verifyCalendarPageUrl() {
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        Assert.assertTrue(currentUrl.contains("calendar"), "URL should contain 'calendar'");
    }

    @Test
    public void verifyCalendarContentIsNotEmpty() {
        CalendarPage calendarPage = new CalendarPage(driver);
        String text = driver.getPageSource();
        Assert.assertFalse(text.isEmpty(), "Calendar page content should not be empty");
    }
}
