package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CoursesPage {

    WebDriver driver;

    By coursesTitle = By.id("coursesTitle");
    By coursesList = By.id("coursesList");
    By courseSelect = By.id("courseSelect");
    By openCourseDetailsButton = By.id("openCourseDetailsButton");
    By favoriteCourseButton = By.id("favoriteCourseButton");
    By clearCourseButton = By.id("clearCourseButton");
    By courseDetails = By.id("courseDetails");
    By favoriteCourseMessage = By.id("favoriteCourseMessage");

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCoursesPageDisplayed() {
        return driver.findElement(coursesTitle).isDisplayed();
    }

    public boolean areCollegeClassesDisplayed() {
        String text = driver.findElement(coursesList).getText().toLowerCase();
        return text.contains("human computer interaction")
                && text.contains("data engineering")
                && text.contains("software testing")
                && text.contains("computer security")
                && text.contains("operating systems");
    }

    public int getCourseCount() {
        String[] courses = driver.findElement(coursesList).getText().split("\n");
        return courses.length;
    }

    public String getCoursesText() {
        return driver.findElement(coursesList).getText();
    }

    public void selectCourse(String courseName) {
        Select select = new Select(driver.findElement(courseSelect));
        select.selectByVisibleText(courseName);
    }

    public void clickOpenCourseDetails() {
        driver.findElement(openCourseDetailsButton).click();
    }

    public void clickFavoriteCourse() {
        driver.findElement(favoriteCourseButton).click();
    }

    public void clickClearCourseSelection() {
        driver.findElement(clearCourseButton).click();
    }

    public String getCourseDetailsText() {
        return driver.findElement(courseDetails).getText();
    }

    public String getFavoriteCourseMessage() {
        return driver.findElement(favoriteCourseMessage).getText();
    }
}