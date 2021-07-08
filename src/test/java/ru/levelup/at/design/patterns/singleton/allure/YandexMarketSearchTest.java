package ru.levelup.at.design.patterns.singleton.allure;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.Test;

@Epic("Some epic 2")
@Feature("Some feature 1")
public class YandexMarketSearchTest extends AbstractSeleniumBaseTest {

    @Test(description = "Поиск товара")
    @Description("Тестирование поискового движка на Яндекс.Маркете")
    @TmsLinks({@TmsLink("TST-2"), @TmsLink("TST-3")})
    @Story("Story 1")
    public void searchTest() {
        actionStep.openYandexMarketIndexPage();
        actionStep.searchProductOnYandexMarket("iPhone");
        assertionStep.assertThatSearchItemsContainExpectedTextOnProductPage("iPhone");
    }
}
