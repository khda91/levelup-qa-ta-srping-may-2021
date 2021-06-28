package ru.levelup.at.selenium.allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelup.at.selenium.allure.step.ActionStep;
import ru.levelup.at.selenium.allure.step.AssertionStep;

public abstract class AbstractSeleniumBaseTest {

    protected WebDriver driver;

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
