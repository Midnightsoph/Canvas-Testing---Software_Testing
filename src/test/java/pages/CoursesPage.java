package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursesPage {

    WebDriver driver;

    By coursesTitle = By.id("coursesTitle");
    By coursesList = By.id("coursesList");

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

    public String getCoursesText() {
        return driver.findElement(coursesList).getText();
    }

    public int getCourseCount() {
        String[] courses = driver.findElement(coursesList).getText().split("\n");
        return courses.length;
    }
}