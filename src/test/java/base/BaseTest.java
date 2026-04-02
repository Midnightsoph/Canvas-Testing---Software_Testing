package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class BaseTest {

    protected WebDriver driver;
    protected String loginPageUrl;
    protected String dashboardUrl;
    protected String coursesUrl;
    protected String assignmentsUrl;
    protected String calendarUrl;
    protected String inboxUrl;
    protected String profileUrl;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String basePath = new File("src/main/resources/CanvasLMS").getAbsolutePath().replace("\\", "/");

        loginPageUrl = "file:///" + basePath + "/login.html";
        dashboardUrl = "file:///" + basePath + "/dashboard.html";
        coursesUrl = "file:///" + basePath + "/courses.html";
        assignmentsUrl = "file:///" + basePath + "/assignments.html";
        calendarUrl = "file:///" + basePath + "/calendar.html";
        inboxUrl = "file:///" + basePath + "/inbox.html";
        profileUrl = "file:///" + basePath + "/profile.html";

        driver.get(loginPageUrl);

        randomDelay();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            randomDelay();
            driver.quit();
        }
    }

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void randomDelay() {
        try {
            Random random = new Random();
            int seconds = 2 + random.nextInt(4); // 2 to 5 seconds
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


