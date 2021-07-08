package ru.levelup.at.design.patterns.factory.allure.step;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.selenium.allure.YandexMarketCategoryPage;
import ru.levelup.at.selenium.allure.YandexMarketComparePage;
import ru.levelup.at.selenium.allure.YandexMarketIndexPage;
import ru.levelup.at.selenium.allure.YandexMarketProductPage;

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
