package ru.levelup.at.selenium.page.objects.steps.step;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    public void assertThatSearchItemsContainExpectedTextOnProductPage(final String expectedText) {
        List<String> actualProductTitles = productPage.getProductTitles();

        assertThat(actualProductTitles)
            .as(String.format("Product titles do not contain search word %s", expectedText))
            .hasSizeGreaterThan(3)
            .usingElementComparator((s1, s2) -> s1.contains(s2) ? 0 : 1)
            .contains(expectedText);
    }

    public void assertThatCompareListContainsAllAddedProducts(List<String> expectedProductTitles) {
        var actualProductTitles = comparePage.getComparedProductTitles();

        assertThat(actualProductTitles)
            .as("Not all items were added to compare list")
            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }
}
