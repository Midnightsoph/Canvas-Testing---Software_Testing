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
        CoursesPage page = new CoursesPage(driver);
        Assert.assertTrue(page.isCoursesPageDisplayed());
    }

    @Test
    public void verifyCollegeClassesAreDisplayed() {
        CoursesPage page = new CoursesPage(driver);
        Assert.assertTrue(page.areCollegeClassesDisplayed());
    }

    @Test
    public void verifyCourseCountIsFive() {
        CoursesPage page = new CoursesPage(driver);
        Assert.assertEquals(page.getCourseCount(), 5);
    }

    @Test
    public void verifyUserCanOpenSelectedCourseDetails() {
        CoursesPage page = new CoursesPage(driver);
        page.selectCourse("Software Testing");
        page.clickOpenCourseDetails();
        pause(1);
        Assert.assertEquals(page.getCourseDetailsText(), "Opened details for Software Testing.");
    }

    @Test
    public void verifyUserCanFavoriteSelectedCourse() {
        CoursesPage page = new CoursesPage(driver);
        page.selectCourse("Operating Systems");
        page.clickFavoriteCourse();
        pause(1);
        Assert.assertEquals(page.getFavoriteCourseMessage(), "Operating Systems added to favorites.");
    }
}