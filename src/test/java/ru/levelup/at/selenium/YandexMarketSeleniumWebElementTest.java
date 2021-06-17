package ru.levelup.at.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class YandexMarketSeleniumWebElementTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru");
        SleepUtil.sleep(1500);
    }

    @Test
    public void listWebElementsTest() {
        var menuItems = driver.findElements(By.cssSelector("[data-zone-name='category-link'] a"));

        menuItems.forEach(item -> System.out.println(item.getText()));

        assertThat(menuItems)
            .as("Items was not found")
            .hasSizeGreaterThan(1);
    }

    @Test
    public void webElementTest() {
        WebElement searchTextBox = driver.findElement(By.id("header-search"));
        searchTextBox.sendKeys("Iphone");

        driver.findElement(By.xpath("//*[@data-r='search-button']")).click();

        SleepUtil.sleep(2000);

        List<WebElement> searchedItems = driver.findElements(By.cssSelector("[data-autotest-id='product-snippet']"));

        assertThat(searchedItems)
            .as("Items was not found")
            .hasSizeGreaterThan(1);
    }

    @Test
    public void listWebElementsNotFoundTest() {
        var menuItems = driver.findElements(By.cssSelector("[data-zone-name='category-link1'] a"));

        menuItems.forEach(item -> System.out.println(item.getText()));

        assertThat(menuItems)
            .as("Items was not found")
            .hasSizeGreaterThan(1);
    }

    @Test
    public void webElementNotFoundTest() {
        WebElement searchTextBox = driver.findElement(By.id("header-search"));
        searchTextBox.sendKeys("Iphone");

        driver.findElement(By.xpath("//*[@data-r='search-button1']")).click();

        SleepUtil.sleep(2000);

        List<WebElement> searchedItems = driver.findElements(By.cssSelector("[data-autotest-id='product-snippet']"));

        assertThat(searchedItems)
            .as("Items was not found")
            .hasSizeGreaterThan(1);
    }

    @Test
    public void listWebElementsVsWebElementTest() {
        var menuItems = driver.findElements(By.cssSelector("[data-zone-name='category-link'] a"));

        menuItems.forEach(item -> System.out.println(item.getText()));

        assertThat(menuItems)
            .as("Items was not found")
            .hasSizeGreaterThan(1);

        System.out.println("================");

        var menuItem = driver.findElement(By.cssSelector("[data-zone-name='category-link'] a"));
        System.out.println(menuItem.getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
