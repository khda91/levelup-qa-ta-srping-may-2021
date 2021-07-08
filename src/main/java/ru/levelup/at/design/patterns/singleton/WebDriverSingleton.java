package ru.levelup.at.design.patterns.singleton;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class WebDriverSingleton {

    private static WebDriverSingleton instance;

    private WebDriver driver;

    private WebDriverSingleton() {
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            instance = null;
        }
    }

    public static WebDriverSingleton getInstance() {
        if (Objects.isNull(instance)) {
            instance = new WebDriverSingleton();
        }
        return instance;
    }
}
