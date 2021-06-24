package ru.levelup.at.selenium.multithreading;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import ru.levelup.at.selenium.page.object.voids.YandexMarketCategoryPage;
import ru.levelup.at.selenium.page.object.voids.YandexMarketComparePage;
import ru.levelup.at.selenium.page.object.voids.YandexMarketIndexPage;
import ru.levelup.at.selenium.page.object.voids.YandexMarketProductPage;

public class YandexMarketCompareProductTest extends AbstractSeleniumBaseTest {

    @Test
    public void addProductToCompareListTest() {
        var yandexMarketIndexPage = new YandexMarketIndexPage(driver.get());
        yandexMarketIndexPage.open();

        yandexMarketIndexPage.selectCategory("Электроника");

        var yandexMarketCategoryPage = new YandexMarketCategoryPage(driver.get());
        yandexMarketCategoryPage.selectSubcategory("Смартфоны");

        List<String> expectedTitles = new ArrayList<>();
        var yandexMarketProductPage = new YandexMarketProductPage(driver.get());
        expectedTitles.add(yandexMarketProductPage.addProductToCompareList(1));
        expectedTitles.add(yandexMarketProductPage.addProductToCompareList(2));

        yandexMarketProductPage.clickCompareButton();

        var actualTitles = new YandexMarketComparePage(driver.get())
            .getComparedProductTitles();

        assertThat(actualTitles)
            .as("Incorrect products in compare list")
            .containsExactlyInAnyOrderElementsOf(expectedTitles);
    }
}
