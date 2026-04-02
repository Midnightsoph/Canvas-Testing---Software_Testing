package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DashboardPage {

    WebDriver driver;

    By dashboardTitle = By.id("dashboardTitle");
    By navCourses = By.id("navCourses");
    By navInbox = By.id("navInbox");
    By navProfile = By.id("navProfile");
    By cards = By.className("card");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        return driver.findElement(dashboardTitle).isDisplayed();
    }

    public boolean isCoursesLinkDisplayed() {
        return driver.findElement(navCourses).isDisplayed();
    }

    public boolean isInboxLinkDisplayed() {
        return driver.findElement(navInbox).isDisplayed();
    }

    public boolean isProfileLinkDisplayed() {
        return driver.findElement(navProfile).isDisplayed();
    }

    public String getDashboardTitleText() {
        return driver.findElement(dashboardTitle).getText();
    }

    public int getDashboardCardCount() {
        List<?> cardsList = driver.findElements(cards);
        return cardsList.size();
    }
}
