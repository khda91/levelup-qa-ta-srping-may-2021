package ru.levelup.at.design.patterns.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverFactory {

    public static WebDriver createWebDriver(String browserName) {
        WebDriver driver;
        if (BrowserType.FIREFOX.equalsIgnoreCase(browserName)) {
            driver = createFirefox();
        } else if (BrowserType.OPERA_BLINK.equalsIgnoreCase(browserName)) {
            driver = createOpera();
        } else if (BrowserType.CHROME.equalsIgnoreCase(browserName)) {
            driver = createChrome();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported browser %s", browserName));
        }

        return driver;
    }

    private static WebDriver createFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createOpera() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
