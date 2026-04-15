package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    By dashboardTitle = By.id("dashboardTitle");
    By navCourses = By.id("navCourses");
    By cards = By.className("card");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        return driver.findElement(dashboardTitle).isDisplayed();
    }

    public String getDashboardTitleText() {
        return driver.findElement(dashboardTitle).getText();
    }

    public boolean isCoursesLinkDisplayed() {
        return driver.findElement(navCourses).isDisplayed();
    }

    public int getDashboardCardCount() {
        return driver.findElements(cards).size();
    }
}