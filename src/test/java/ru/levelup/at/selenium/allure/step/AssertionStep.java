package ru.levelup.at.selenium.allure.step;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Searched items should contain '{expectedText}' text")
    public void assertThatSearchItemsContainExpectedTextOnProductPage(final String expectedText) {
        List<String> actualProductTitles = productPage.getProductTitles();

        assertThat(actualProductTitles)
            .as(String.format("Product titles do not contain search word %s", expectedText))
            .hasSizeGreaterThan(3)
            .usingElementComparator((s1, s2) -> s1.contains(s2) ? 0 : 1)
            .contains(expectedText);
    }

    @Step("{expectedProductTitles} products should be added to compare list")
    public void assertThatCompareListContainsAllAddedProducts(List<String> expectedProductTitles) {
        var actualProductTitles = comparePage.getComparedProductTitles();

        assertThat(actualProductTitles)
            .as("Not all items were added to compare list")
            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }
}
