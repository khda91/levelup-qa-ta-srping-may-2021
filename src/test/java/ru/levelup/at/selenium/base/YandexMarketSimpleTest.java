package ru.levelup.at.selenium.base;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class YandexMarketSimpleTest {

    @Test
    public void openYandexMarketHomePageTest() {
        /* For windows
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/drivers/chrome/chromedriver.exe");
         */
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru");

        SleepUtil.sleep(2500);

        assertThat(driver.getTitle())
            .as("Title is not matched with the expected title")
            .isEqualTo("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");

        driver.quit();
    }

    @Test
    public void openFirefoxYandexMarketHomePageTest() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/selenium/drivers/firefox/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://market.yandex.ru");

        SleepUtil.sleep(2500);

        assertThat(driver.getTitle())
            .as("Title is not matched with the expected title")
            .isEqualTo("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");

        driver.quit();
    }

    @Test
    public void openInDifferentBrowsersYandexMarketHomePageTest() {
        WebDriver driver;
        if ("FIREFOX".equalsIgnoreCase(System.getProperty("browser.name"))) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/selenium/drivers/firefox/geckodriver");
            driver = new FirefoxDriver();
        } else if ("CHROME".equalsIgnoreCase(System.getProperty("browser.name"))) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/drivers/chrome/chromedriver");
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Incorrect browser name");
        }

        driver.navigate().to("https://market.yandex.ru");

        SleepUtil.sleep(2500);

        assertThat(driver.getTitle())
            .as("Title is not matched with the expected title")
            .isEqualTo("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");

        driver.quit();
    }

    @Test
    public void openInDifferentBrowsersWebdriverManagerYandexMarketHomePageTest() {
        WebDriver driver;
        if ("FIREFOX".equalsIgnoreCase(System.getProperty("browser.name"))) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("CHROME".equalsIgnoreCase(System.getProperty("browser.name"))) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Incorrect browser name");
        }

        driver.navigate().to("https://market.yandex.ru");

        SleepUtil.sleep(2500);

        assertThat(driver.getTitle())
            .as("Title is not matched with the expected title")
            .isEqualTo("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");

        driver.quit();
    }
}
