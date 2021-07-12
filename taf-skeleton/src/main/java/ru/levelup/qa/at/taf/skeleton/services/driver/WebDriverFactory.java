package ru.levelup.qa.at.taf.skeleton.services.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.levelup.qa.at.taf.skeleton.config.TestConfig;

import java.net.MalformedURLException;
import java.net.URL;

public final class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(Browser browser, Boolean isRemote) {
        WebDriver driver;
        if (isRemote) {
            driver = createRemoteDriver(browser);
        } else {
            switch (browser) {
                case FIREFOX:
                    driver = createFireFox();
                    break;
                case IE:
                    driver = createIE();
                    break;
                default:
                    driver = createChrome();
                    break;
            }
        }
        // driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createIE() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private static WebDriver createFireFox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createRemoteDriver(Browser browser) {
        URL url = TestConfig.getInstance().remoteDriverUrl();
        WebDriver driver;
        switch (browser) {
            case FIREFOX:
//                try {
//                    URL test = new URL("http://localhost:4444/wd/hub");
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
                driver = new RemoteWebDriver(url, createFirefoxCapabilities());
                break;

            default:
                driver = new RemoteWebDriver(url, createChromeCapabilities());
                break;
        }
        return driver;
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
    }
}
