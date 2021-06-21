package ru.levelup.at.selenium;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexMarketSeleniumActionBuilderTest extends AbstractSeleniumBaseTest {

    private WebDriverWait wait;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.navigate().to(URL);

        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @Test
    public void addProductToCompareListTest() {
        List<String> expectedTitles = new ArrayList<>();

        wait.until(elementToBeClickable(xpath("//span[text() = 'Электроника']"))).click();
        wait.until(elementToBeClickable(linkText("Смартфоны"))).click();

        var productCards =
            wait.until(numberOfElementsToBeMoreThan(cssSelector("[data-autotest-id='product-snippet']"), 2));

        var productCard = productCards.get(0);
        var productCardTitle = productCard.findElement(cssSelector("h3[data-zone-name='title'] span"))
                                          .getText();

        var addToCompareButton = wait.until(
            presenceOfNestedElementLocatedBy(productCard, xpath("//div[contains(@aria-label, 'сравнению')]")));

        Actions actions = new Actions(driver);

        actions
            .moveToElement(addToCompareButton)
            .click()
            .perform();

        expectedTitles.add(productCardTitle);

        productCard = productCards.get(1);
        productCardTitle = productCard.findElement(cssSelector("h3[data-zone-name='title'] span"))
                                      .getText();

        addToCompareButton = wait.until(
            presenceOfNestedElementLocatedBy(productCard, xpath("//div[contains(@aria-label, 'сравнению')]")));

        actions
            .moveToElement(addToCompareButton)
            .click()
            .perform();

        expectedTitles.add(productCardTitle);

        wait.until(elementToBeClickable(xpath("//a/span[text()='Сравнить']"))).click();

        var actualWebElements = wait.until(numberOfElementsToBe(className("_27nuSZ19h7"), expectedTitles.size()));

        var actualTitles = actualWebElements
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());

        assertThat(actualTitles)
            .as("Incorrect products in compare list")
            .containsExactlyInAnyOrderElementsOf(expectedTitles);
    }
}
