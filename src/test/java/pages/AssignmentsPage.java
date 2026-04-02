package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignmentsPage {

    WebDriver driver;

    By assignmentsTitle = By.id("assignmentsTitle");
    By assignmentsList = By.id("assignmentsList");

    public AssignmentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAssignmentsPageDisplayed() {
        return driver.findElement(assignmentsTitle).isDisplayed();
    }

    public boolean areAssignmentsDisplayed() {
        return driver.findElement(assignmentsList).getText().length() > 0;
    }

    public String getAssignmentsText() {
        return driver.findElement(assignmentsList).getText();
    }
}
