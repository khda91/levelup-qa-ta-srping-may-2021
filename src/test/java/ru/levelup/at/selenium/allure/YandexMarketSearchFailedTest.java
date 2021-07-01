package ru.levelup.at.selenium.allure;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Some epic 1")
@Feature("Some feature 2")
public class YandexMarketSearchFailedTest extends AbstractSeleniumBaseTest {

    @Test(description = "Поиск товара")
    @Description("Тестирование поискового движка на Яндекс.Маркете")
    @Story("Some story 3")
    public void searchTest() {
        actionStep.openYandexMarketIndexPage();
        actionStep.searchProductOnYandexMarket("iPhone");
        assertionStep.assertThatSearchItemsContainExpectedTextOnProductPage("samsung");
    }
}
