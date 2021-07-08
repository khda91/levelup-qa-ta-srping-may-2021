package ru.levelup.at.design.patterns.singleton.allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelup.at.design.patterns.singleton.WebDriverSingleton;
import ru.levelup.at.design.patterns.singleton.allure.step.ActionStep;
import ru.levelup.at.design.patterns.singleton.allure.step.AssertionStep;

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
    public void setUp() {
        // driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        // driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));

        driver = WebDriverSingleton.getInstance().getDriver();
        driver.manage().window().maximize();

        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.getInstance().closeDriver();
    }
}
