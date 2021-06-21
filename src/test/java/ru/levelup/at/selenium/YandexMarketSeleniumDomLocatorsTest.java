package ru.levelup.at.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class YandexMarketSeleniumDomLocatorsTest extends AbstractSeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.navigate().to(URL);
        SleepUtil.sleep(1000);
    }

    @Test
    public void idLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.id("header-search"));
        searchTextBox.sendKeys("iphone");

        SleepUtil.sleep(2000);
        // getText не работает для text box
        // String actualSearchText = searchTextBox.getText();
        String actualSearchText = searchTextBox.getAttribute("value");

        assertThat(actualSearchText).isEqualTo("iphone");
    }

    @Test
    public void classNameLocatorText() {
        WebElement searchTextBox = driver.findElement(By.className("nQ8aBP7fBN"));
        searchTextBox.sendKeys("iphone");

        SleepUtil.sleep(2000);
        // getText не работает для text box
        // String actualSearchText = searchTextBox.getText();
        String actualSearchText = searchTextBox.getAttribute("value");

        assertThat(actualSearchText).isEqualTo("iphone");
    }

    @Test
    public void withMultipleClassNameLocatorText() {
        WebElement searchButton = driver.findElement(By.className("BQHgUWjkfR"));
        SleepUtil.sleep(2000);

        String actualButtonName = searchButton.getText();

        assertThat(actualButtonName).containsIgnoringCase("Найти");
    }

    @Test
    public void nameLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.name("text"));
        searchTextBox.sendKeys("iphone");

        SleepUtil.sleep(2000);
        // getText не работает для text box
        // String actualSearchText = searchTextBox.getText();
        String actualSearchText = searchTextBox.getAttribute("value");

        assertThat(actualSearchText).isEqualTo("iphone");
    }

    @Test
    public void linkTextLocatorTest() {
        WebElement link = driver.findElement(By.linkText("Электроника"));

        SleepUtil.sleep(2000);
        String actualLinkText = link.getText();

        assertThat(actualLinkText).isEqualTo("Электроника");
    }

    @Test
    public void partialLinkTextLocatorTest() {
        WebElement link = driver.findElement(By.partialLinkText("Электр"));

        SleepUtil.sleep(2000);
        String actualLinkText = link.getText();

        assertThat(actualLinkText).isEqualTo("Электроника");
    }

    @Test
    public void tagNameLocatorTest() {
        var elements = driver.findElements(By.tagName("div"));

        SleepUtil.sleep(2000);

        assertThat(elements).hasSizeGreaterThan(10);

        System.out.println("div count -> " + elements.size());
    }
}
