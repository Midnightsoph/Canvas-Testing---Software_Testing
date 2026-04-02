package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class NavigationTests extends BaseTest {

    @BeforeMethod
    public void loginFirst() {
        driver.get(loginPageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "test123");
        pause(3);
    }

    @Test
    public void verifyNavigationToDashboard() {
        driver.get(dashboardUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard.html"));
    }

    @Test
    public void verifyNavigationToCourses() {
        driver.get(coursesUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains("courses.html"));
    }

    @Test
    public void verifyNavigationToAssignments() {
        driver.get(assignmentsUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains("assignments.html"));
    }

    @Test
    public void verifyNavigationToCalendar() {
        driver.get(calendarUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains("calendar.html"));
    }

    @Test
    public void verifyNavigationToInbox() {
        driver.get(inboxUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains("inbox.html"));
    }

    @Test
    public void verifyNavigationToProfile() {
        driver.get(profileUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains("profile.html"));
    }
    @Test
    public void verifyLogoutReturnsToLoginPage() {
        driver.get(dashboardUrl);
        pause(1);
        driver.findElement(org.openqa.selenium.By.id("logoutLink")).click();
        pause(1);
        Assert.assertTrue(driver.getCurrentUrl().contains("login.html"));
    }
}