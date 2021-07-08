package ru.levelup.at.design.patterns.factory;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        var browserName = System.getProperty("browser", "chrome");
        if (Objects.isNull(driver)) {
            driver = WebDriverFactory.createWebDriver(browserName);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
