package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    WebDriver driver;

    By profileTitle = By.id("profileTitle");
    By profileName = By.id("profileName");
    By profileEmail = By.id("profileEmail");
    By profileMajor = By.id("profileMajor");
    By editName = By.id("editName");
    By editEmail = By.id("editEmail");
    By editMajor = By.id("editMajor");
    By saveProfileButton = By.id("saveProfileButton");
    By profileStatus = By.id("profileStatus");

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

    public void editName(String name) {
        driver.findElement(editName).clear();
        driver.findElement(editName).sendKeys(name);
    }

    public void editEmail(String email) {
        driver.findElement(editEmail).clear();
        driver.findElement(editEmail).sendKeys(email);
    }

    public void editMajor(String major) {
        driver.findElement(editMajor).clear();
        driver.findElement(editMajor).sendKeys(major);
    }

    public void clickSaveProfile() {
        driver.findElement(saveProfileButton).click();
    }

    public String getProfileStatus() {
        return driver.findElement(profileStatus).getText();
    }

    public String getProfileNameText() {
        return driver.findElement(profileName).getText();
    }

    public String getProfileMajorText() {
        return driver.findElement(profileMajor).getText();
    }
}