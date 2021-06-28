package ru.levelup.at.selenium.page.objects.steps.step;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.selenium.page.object.steps.YandexMarketCategoryPage;
import ru.levelup.at.selenium.page.object.steps.YandexMarketComparePage;
import ru.levelup.at.selenium.page.object.steps.YandexMarketIndexPage;
import ru.levelup.at.selenium.page.object.steps.YandexMarketProductPage;

public abstract class AbstractStep {

    private WebDriver driver;

    protected YandexMarketIndexPage indexPage;
    protected YandexMarketCategoryPage categoryPage;
    protected YandexMarketProductPage productPage;
    protected YandexMarketComparePage comparePage;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
        indexPage = new YandexMarketIndexPage(driver);
        categoryPage = new YandexMarketCategoryPage(driver);
        productPage = new YandexMarketProductPage(driver);
        comparePage = new YandexMarketComparePage(driver);
    }
}
