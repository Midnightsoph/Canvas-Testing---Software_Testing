package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class NavigationTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        driver.get(loginPageUrl);
        new LoginPage(driver).login("student@test.com", "test123");
        pause(2);
    }

    @Test
    public void dashboardToCourses() {
        driver.findElement(By.id("navCourses")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("courses.html"));
    }

    @Test
    public void coursesToAssignments() {
        driver.get(coursesUrl);
        driver.findElement(By.id("navAssignments")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("assignments.html"));
    }

    @Test
    public void assignmentsToCalendar() {
        driver.get(assignmentsUrl);
        driver.findElement(By.id("navCalendar")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("calendar.html"));
    }

    @Test
    public void calendarToInbox() {
        driver.get(calendarUrl);
        driver.findElement(By.id("navInbox")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inbox.html"));
    }

    @Test
    public void logoutTest() {
        driver.findElement(By.id("logoutLink")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("login.html"));
    }
}