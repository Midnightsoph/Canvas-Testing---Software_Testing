package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AssignmentsPage;
import pages.LoginPage;

public class AssignmentsTests extends BaseTest {

    @BeforeMethod
    public void loginAndOpenAssignments() {
        driver.get(loginPageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "test123");
        pause(3);
        driver.get(assignmentsUrl);
        pause(3);
    }

    @Test
    public void verifyAssignmentsPageIsDisplayed() {
        AssignmentsPage assignmentsPage = new AssignmentsPage(driver);
        Assert.assertTrue(assignmentsPage.isAssignmentsPageDisplayed());
    }

    @Test
    public void verifyAssignmentsAreDisplayed() {
        AssignmentsPage assignmentsPage = new AssignmentsPage(driver);
        Assert.assertTrue(assignmentsPage.areAssignmentsDisplayed());
    }

    @Test
    public void verifyAssignmentsContainSoftwareTestingProject() {
        AssignmentsPage assignmentsPage = new AssignmentsPage(driver);
        Assert.assertTrue(assignmentsPage.getAssignmentsText().contains("Software Testing Project"));
    }

    @Test
    public void verifyAssignmentsListIsNotEmpty() {
        AssignmentsPage assignmentsPage = new AssignmentsPage(driver);
        String text = assignmentsPage.getAssignmentsText();
        Assert.assertFalse(text.isEmpty(), "Assignments list should not be empty");
    }

    @Test
    public void verifyAssignmentsPageUrl() {
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        Assert.assertTrue(currentUrl.contains("assignments"), "URL should contain 'assignments'");
    }
}