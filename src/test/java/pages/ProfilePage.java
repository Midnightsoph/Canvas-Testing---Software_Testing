package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    WebDriver driver;

    By profileTitle = By.id("profileTitle");
    By profileName = By.id("profileName");
    By profileEmail = By.id("profileEmail");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProfilePageDisplayed() {
        return driver.findElement(profileTitle).isDisplayed();
    }

    public boolean isProfileNameDisplayed() {
        return driver.findElement(profileName).isDisplayed();
    }

    public boolean isProfileEmailDisplayed() {
        return driver.findElement(profileEmail).isDisplayed();
    }

    public String getProfileEmailText() {
        return driver.findElement(profileEmail).getText();
    }
}