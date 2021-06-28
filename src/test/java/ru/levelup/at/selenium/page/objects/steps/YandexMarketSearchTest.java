package ru.levelup.at.selenium.page.objects.steps;

import org.testng.annotations.Test;

public class YandexMarketSearchTest extends AbstractSeleniumBaseTest {

    @Test
    public void searchTest() {
        actionStep.openYandexMarketIndexPage();
        actionStep.searchProductOnYandexMarket("iPhone");
        assertionStep.assertThatSearchItemsContainExpectedTextOnProductPage("iPhone");
    }
}
