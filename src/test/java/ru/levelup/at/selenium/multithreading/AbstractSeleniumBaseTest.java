package ru.levelup.at.selenium.multithreading;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractSeleniumBaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver.set(new ChromeDriver());
    }

    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}
