package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTests extends BaseTest {

    @BeforeMethod
    public void loginAndOpenDashboard() {
        driver.get(loginPageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "test123");
        pause(2);
        driver.get(dashboardUrl);
        pause(2);
    }

    @Test
    public void verifyDashboardPageIsDisplayed() {
        DashboardPage page = new DashboardPage(driver);
        Assert.assertTrue(page.isDashboardDisplayed());
    }

    @Test
    public void verifyDashboardTitleTextIsCorrect() {
        DashboardPage page = new DashboardPage(driver);
        Assert.assertEquals(page.getDashboardTitleText(), "Dashboard");
    }

    @Test
    public void verifyCoursesLinkIsDisplayed() {
        DashboardPage page = new DashboardPage(driver);
        Assert.assertTrue(page.isCoursesLinkDisplayed());
    }

    @Test
    public void verifyDashboardHasFourCards() {
        DashboardPage page = new DashboardPage(driver);
        Assert.assertEquals(page.getDashboardCardCount(), 4);
    }

    @Test
    public void verifyUserCanNavigateToAssignmentsFromDashboard() {
        driver.findElement(By.id("navAssignments")).click();
        pause(2);
        Assert.assertTrue(driver.getCurrentUrl().contains("assignments.html"));
    }
}