package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AssignmentsPage;
import pages.LoginPage;

public class AssignmentsTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        driver.get(loginPageUrl);
        new LoginPage(driver).login("student@test.com", "test123");
        pause(3);
        driver.get(assignmentsUrl);
        pause(3);
    }

    @Test
    public void verifyAssignmentsPageDisplayed() {
        Assert.assertTrue(new AssignmentsPage(driver).isAssignmentsPageDisplayed());
    }

    @Test
    public void verifyAssignmentsListContainsSoftwareTesting() {
        Assert.assertTrue(new AssignmentsPage(driver).getAssignmentsText().contains("Software Testing Final Project"));
    }

    @Test
    public void verifyUserCanSubmitSelectedAssignment() {
        AssignmentsPage page = new AssignmentsPage(driver);
        page.selectAssignment("Software Testing Final Project");
        page.enterAssignmentText("My final project submission");
        page.clickSubmitAssignment();
        pause(2);
        Assert.assertEquals(page.getAssignmentMessage(), "Assignment submitted successfully.");
    }

    @Test
    public void verifyUserCanMarkAssignmentComplete() {
        AssignmentsPage page = new AssignmentsPage(driver);
        page.selectAssignment("Operating Systems Process Analysis");
        page.clickMarkComplete();
        pause(2);
        Assert.assertEquals(page.getAssignmentMessage(), "Operating Systems Process Analysis marked as complete.");
    }

    @Test
    public void verifyUserCanClearAssignmentForm() {
        AssignmentsPage page = new AssignmentsPage(driver);
        page.selectAssignment("HCI Usability Review");
        page.enterAssignmentText("Draft submission");
        page.clickClearAssignmentForm();
        pause(2);
        Assert.assertEquals(page.getAssignmentMessage(), "Assignment form cleared.");
    }
}