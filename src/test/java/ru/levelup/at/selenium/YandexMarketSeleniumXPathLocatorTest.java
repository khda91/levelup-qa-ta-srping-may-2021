package ru.levelup.at.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class YandexMarketSeleniumXPathLocatorTest extends AbstractSeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.navigate().to(URL);
        SleepUtil.sleep(1000);
    }

    @Test
    public void idLocatorTest() {
        // WebElement searchTextBox = driver.findElement(By.id("header-search"));
        // WebElement searchTextBox = driver.findElement(By.cssSelector("#header-search"));
        WebElement searchTextBox = driver.findElement(By.xpath("//*[@id='header-search']"));
        searchTextBox.sendKeys("iphone");

        SleepUtil.sleep(2000);
        // getText не работает для text box
        // String actualSearchText = searchTextBox.getText();
        String actualSearchText = searchTextBox.getAttribute("value");

        assertThat(actualSearchText).isEqualTo("iphone");
    }

    @Test
    public void classNameLocatorText() {
        // WebElement searchTextBox = driver.findElement(By.className("nQ8aBP7fBN"));
        // WebElement searchTextBox = driver.findElement(By.cssSelector("[class='nQ8aBP7fBN']"));
        // WebElement searchTextBox = driver.findElement(By.cssSelector(".nQ8aBP7fBN"));
        WebElement searchTextBox = driver.findElement(By.xpath("//*[@class='nQ8aBP7fBN']"));
        searchTextBox.sendKeys("iphone");

        SleepUtil.sleep(2000);
        // getText не работает для text box
        // String actualSearchText = searchTextBox.getText();
        String actualSearchText = searchTextBox.getAttribute("value");

        assertThat(actualSearchText).isEqualTo("iphone");
    }

    @Test
    public void withMultipleClassNameLocatorText() {
        WebElement searchButton = driver.findElement(By.xpath("//*[contains(@class, 'BQHgUWjkfR')]"));
        SleepUtil.sleep(2000);

        String actualButtonName = searchButton.getText();

        assertThat(actualButtonName).containsIgnoringCase("Найти");
    }

    @Test
    public void nameLocatorTest() {
        // WebElement searchTextBox = driver.findElement(By.name("text"));
        //        WebElement searchTextBox = driver.findElement(By.cssSelector("[name='text']"));
        WebElement searchTextBox = driver.findElement(By.xpath("//*[@name='text']"));
        searchTextBox.sendKeys("iphone");

        SleepUtil.sleep(2000);
        // getText не работает для text box
        // String actualSearchText = searchTextBox.getText();
        String actualSearchText = searchTextBox.getAttribute("value");

        assertThat(actualSearchText).isEqualTo("iphone");
    }

    @Test
    public void otherAttributeLocatorTest() {
        WebElement searchButton = driver.findElement(By.xpath("//*[@data-r='search-button']"));
        SleepUtil.sleep(2000);

        String actualButtonName = searchButton.getText();

        assertThat(actualButtonName).containsIgnoringCase("Найти");
    }

    @Test
    public void linkTextLocatorTest() {
        // WebElement link = driver.findElement(By.xpath("//*[. = 'Электроника']"));
        WebElement link = driver.findElement(By.xpath("//*[text() = 'Электроника']"));

        SleepUtil.sleep(2000);
        String actualLinkText = link.getText();

        assertThat(actualLinkText).isEqualTo("Электроника");
    }

    @Test
    public void partialLinkTextLocatorTest() {
        // WebElement link = driver.findElement(By.xpath("//*[contains(., 'Электр')]"));
        WebElement link = driver.findElement(By.xpath("//*[contains(text(), 'Электр')]"));

        SleepUtil.sleep(2000);
        String actualLinkText = link.getText();

        assertThat(actualLinkText).isEqualTo("Электроника");
    }

    @Test
    public void combinedCssLocatorTest() {
        //        WebElement link = driver.findElement(By.cssSelector("[data-zone-name='category-link'] a span"));
        WebElement link = driver.findElement(By.xpath("//*[@data-zone-name='category-link']//a/span"));

        SleepUtil.sleep(2000);
        String actualLinkText = link.getText();

        assertThat(actualLinkText).isEqualTo("Экспресс");
    }
}
