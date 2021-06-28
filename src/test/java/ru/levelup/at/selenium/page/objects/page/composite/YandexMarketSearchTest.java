package ru.levelup.at.selenium.page.objects.page.composite;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.testng.annotations.Test;
import ru.levelup.at.selenium.page.object.page.composite.YandexMarketIndexPage;
import ru.levelup.at.selenium.page.object.page.composite.YandexMarketProductPage;

public class YandexMarketSearchTest extends AbstractSeleniumBaseTest {

    @Test
    public void searchTest() {
        var indexPage = new YandexMarketIndexPage(driver);
        indexPage.open();

        indexPage.getHeader().enterSearchText("iPhone");
        indexPage.getHeader().clickSearchButton();

        var productPage = new YandexMarketProductPage(driver);
        List<String> actualProductTitles = productPage.getProductTitles();

        assertThat(actualProductTitles)
            .as("Product titles do not contain search word")
            .hasSizeGreaterThan(3)
            .usingElementComparator((s1, s2) -> s1.contains(s2) ? 0 : 1)
            .contains("iPhone");
    }
}
