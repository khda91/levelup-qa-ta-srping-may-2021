package ru.levelup.at.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexMarketSeleniumExplicitWaitTest extends AbstractSeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.navigate().to(URL);
    }

    @Test
    public void explicitWaitTimeoutTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search")));
        searchTextBox.sendKeys("Iphone");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-r='search-button']"))).click();

        List<WebElement> searchedItems = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By.cssSelector("[data-autotest-id='product-snippet']"), 1));

        assertThat(searchedItems)
            .as("Items was not found")
            .hasSizeGreaterThan(1);
    }

    @Test
    public void explicitWaitDynamicElementTimeoutTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10, 1500);
        WebElement searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search")));
        searchTextBox.sendKeys("Iphone");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-r='search-button']"))).click();

        List<WebElement> searchedItems = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By.cssSelector("[data-autotest-id='product-snippet1']"), 1));

        assertThat(searchedItems)
            .as("Items was not found")
            .hasSizeGreaterThan(1);
    }
}
