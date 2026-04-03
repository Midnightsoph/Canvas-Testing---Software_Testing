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
        pause(2);
        driver.get(coursesUrl);
        pause(2);
    }

    @Test
    public void verifyCoursesPageIsDisplayed() {
        CoursesPage coursesPage = new CoursesPage(driver);
        Assert.assertTrue(coursesPage.getCoursesText().length() > 0);
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

    @Test
    public void verifyCoursesPageUrl() {
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        Assert.assertTrue(currentUrl.contains("courses"), "URL should contain 'courses'");
    }
}
