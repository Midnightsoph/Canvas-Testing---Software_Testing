package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTests extends BaseTest {

    @BeforeMethod
    public void loginFirst() {
        driver.get(loginPageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "test123");
        pause(3);
    }

    @Test
    public void verifyDashboardPageIsDisplayed() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @Test
    public void verifyCoursesLinkIsDisplayed() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isCoursesLinkDisplayed());
    }

    @Test
    public void verifyInboxLinkIsDisplayed() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isInboxLinkDisplayed());
    }

    @Test
    public void verifyProfileLinkIsDisplayed() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isProfileLinkDisplayed());
    }
    @Test
    public void verifyDashboardTitleTextIsCorrect() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.getDashboardTitleText(), "Dashboard");
    }

    @Test
    public void verifyDashboardHasThreeCards() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.getDashboardCardCount(), 3);
    }
}