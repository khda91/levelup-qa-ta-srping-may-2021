package ru.levelup.at.selenium.page.objects.steps;

import java.util.List;
import org.testng.annotations.Test;

public class YandexMarketCompareProductTest extends AbstractSeleniumBaseTest {

    @Test
    public void addProductsToCompareListTest() {
        actionStep.openYandexMarketIndexPage();
        actionStep.selectCategoryAndSubcategoryOnYandexMarket("Электроника", "Смартфоны");
        List<String> expectedProductTitles =
            actionStep.addProductsToCompareListOnYandexMarketProductPage(1, 2, 3);
        assertionStep.assertThatCompareListContainsAllAddedProducts(expectedProductTitles);
    }
}
