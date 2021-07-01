package ru.levelup.at.selenium.allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelup.at.selenium.allure.step.ActionStep;
import ru.levelup.at.selenium.allure.step.AssertionStep;

public abstract class AbstractSeleniumBaseTest {

    // public static WebDriver driver;
    protected WebDriver driver;

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        // driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        // driver = new ChromeDriver();

        boolean headless = Boolean.parseBoolean(System.getProperty("headless.browser", "false"));

        driver = new ChromeDriver(new ChromeOptions().setHeadless(headless));
        driver.manage().window().maximize();
        testContext.setAttribute("web.driver", driver);

        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
