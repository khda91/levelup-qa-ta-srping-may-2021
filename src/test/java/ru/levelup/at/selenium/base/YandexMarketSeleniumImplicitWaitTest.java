package ru.levelup.at.selenium.base;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexMarketSeleniumImplicitWaitTest extends AbstractSeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void implicitWaitTimeoutTest() {
        WebElement searchTextBox = driver.findElement(By.id("header-search"));
        searchTextBox.sendKeys("Iphone");

        driver.findElement(By.xpath("//*[@data-r='search-button']")).click();

        List<WebElement> searchedItems = driver.findElements(By.cssSelector("[data-autotest-id='product-snippet']"));

        assertThat(searchedItems)
            .as("Items was not found")
            .hasSizeGreaterThan(1);
    }

    @Test
    public void implicitWaitDynamicElementTimeoutTest() {
        WebElement searchTextBox = driver.findElement(By.id("header-search"));
        searchTextBox.sendKeys("Iphone");

        driver.findElement(By.xpath("//*[@data-r='search-button']")).click();

        List<WebElement> searchedItems = driver.findElements(By.cssSelector("[data-autotest-id='product-snippet1']"));

        assertThat(searchedItems)
            .as("Items was not found")
            .hasSizeGreaterThan(1);
    }
}
