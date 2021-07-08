package ru.levelup.at.design.patterns.factory.allure;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.at.design.patterns.factory.WebDriverSingleton;
import ru.levelup.at.design.patterns.factory.allure.step.ActionStep;
import ru.levelup.at.design.patterns.factory.allure.step.AssertionStep;

public abstract class AbstractSeleniumBaseTest {

    // public static WebDriver driver;
    protected WebDriver driver;

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        // driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        // driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));

        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
        testContext.setAttribute("web.driver", driver);

        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
