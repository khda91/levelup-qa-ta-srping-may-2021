package ru.levelup.at.selenium.page.objects.page.composite;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.testng.annotations.Test;
import ru.levelup.at.selenium.page.object.page.composite.YandexMarketCategoryPage;
import ru.levelup.at.selenium.page.object.page.composite.YandexMarketComparePage;
import ru.levelup.at.selenium.page.object.page.composite.YandexMarketIndexPage;
import ru.levelup.at.selenium.page.object.page.composite.YandexMarketProductPage;

public class YandexMarketCompareProductTest extends AbstractSeleniumBaseTest {

    @Test
    public void addProductsToCompareListTest() {
        var indexPage = new YandexMarketIndexPage(driver);
        indexPage.open();
        indexPage.getHeader().selectCategory("Электроника");

        var categoryPage = new YandexMarketCategoryPage(driver);
        categoryPage.getMenu().selectSubcategory("Смартфоны");

        var productPage = new YandexMarketProductPage(driver);
        var productOne = productPage.addToCompare(1);
        var productTwo = productPage.addToCompare(2);
        var productThree = productPage.addToCompare(3);
        productPage.clickCompareButton();

        var expectedProductTitles = List.of(productOne, productTwo, productThree);

        var comparePage = new YandexMarketComparePage(driver);
        var actualProductTitles = comparePage.getComparedProductTitles();

        assertThat(actualProductTitles)
            .as("Not all items were added to compare list")
            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }
}
