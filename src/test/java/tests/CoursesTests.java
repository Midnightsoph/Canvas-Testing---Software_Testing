package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CoursesPage;
import pages.LoginPage;

public class CoursesTests extends BaseTest {

    @BeforeMethod
    public void loginAndOpenCourses() {
        driver.get(loginPageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student@test.com", "test123");
        pause(3);
        driver.get(coursesUrl);
        pause(3);
    }

    @Test
    public void verifyCoursesPageIsDisplayed() {
        CoursesPage coursesPage = new CoursesPage(driver);
        Assert.assertTrue(coursesPage.isCoursesPageDisplayed());
    }

    @Test
    public void verifyCollegeClassesAreDisplayed() {
        CoursesPage coursesPage = new CoursesPage(driver);
        Assert.assertTrue(coursesPage.areCollegeClassesDisplayed());
    }
    @Test
    public void verifyCoursesListContainsOperatingSystems() {
        CoursesPage coursesPage = new CoursesPage(driver);
        Assert.assertTrue(coursesPage.getCoursesText().contains("Operating Systems"));
    }

    @Test
    public void verifyCourseCountIsFive() {
        CoursesPage coursesPage = new CoursesPage(driver);
        Assert.assertEquals(coursesPage.getCourseCount(), 5);
    }
}
