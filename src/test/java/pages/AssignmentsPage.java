package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentsPage {

    WebDriver driver;

    By assignmentsTitle = By.id("assignmentsTitle");
    By assignmentsList = By.id("assignmentsList");
    By assignmentSelect = By.id("assignmentSelect");
    By assignmentInput = By.id("assignmentInput");
    By submitAssignmentButton = By.id("submitAssignmentButton");
    By markCompleteButton = By.id("markCompleteButton");
    By clearAssignmentButton = By.id("clearAssignmentButton");
    By assignmentMessage = By.id("assignmentMessage");

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

    public void selectAssignment(String assignmentName) {
        Select select = new Select(driver.findElement(assignmentSelect));
        select.selectByVisibleText(assignmentName);
    }

    public void enterAssignmentText(String text) {
        driver.findElement(assignmentInput).clear();
        driver.findElement(assignmentInput).sendKeys(text);
    }

    public void clickSubmitAssignment() {
        driver.findElement(submitAssignmentButton).click();
    }

    public void clickMarkComplete() {
        driver.findElement(markCompleteButton).click();
    }

    public void clickClearAssignmentForm() {
        driver.findElement(clearAssignmentButton).click();
    }

    public String getAssignmentMessage() {
        return driver.findElement(assignmentMessage).getText();
    }
}