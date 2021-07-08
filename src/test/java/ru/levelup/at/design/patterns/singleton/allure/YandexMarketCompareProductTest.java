package ru.levelup.at.design.patterns.singleton.allure;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import java.util.List;
import org.testng.annotations.Test;

@Epic("Some epic 1")
@Feature("Some feature 1")
public class YandexMarketCompareProductTest extends AbstractSeleniumBaseTest {

    @Test(description = "Добавление продуктов к сравнению")
    @TmsLink("TST-1")
    @Story("Some story 1")
    public void addProductsToCompareListTest() {
        actionStep.openYandexMarketIndexPage();
        actionStep.selectCategoryAndSubcategoryOnYandexMarket("Электроника", "Смартфоны");
        List<String> expectedProductTitles =
            actionStep.addProductsToCompareListOnYandexMarketProductPage(1, 2, 3);
        assertionStep.assertThatCompareListContainsAllAddedProducts(expectedProductTitles);
    }

    @Test(description = "Добавление продуктов к сравнению")
    @TmsLink("TST-4")
    @Issue("BUG-1")
    @Story("Some story 2")
    public void addProductsToCompareListFailedTest() {
        actionStep.openYandexMarketIndexPage();
        actionStep.selectCategoryAndSubcategoryOnYandexMarket("Электроника", "Смартфо");
        List<String> expectedProductTitles =
            actionStep.addProductsToCompareListOnYandexMarketProductPage(1, 2, 3);
        assertionStep.assertThatCompareListContainsAllAddedProducts(expectedProductTitles);
    }
}
