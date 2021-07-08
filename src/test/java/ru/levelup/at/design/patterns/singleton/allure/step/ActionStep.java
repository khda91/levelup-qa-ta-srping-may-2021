package ru.levelup.at.design.patterns.singleton.allure.step;

import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("I open Yandex Market Index page")
    public void openYandexMarketIndexPage() {
        indexPage.open();
    }

    @Step("I search product '{0}' on Yandex Market page")
    public void searchProductOnYandexMarket(final String productTitle) {
        indexPage.getHeader().enterSearchText(productTitle);
        indexPage.getHeader().clickSearchButton();
        ;
    }

    @Step("I select '{category}' category and '{subcategory}' on Yandex Market")
    public void selectCategoryAndSubcategoryOnYandexMarket(final String category, final String subcategory) {
        indexPage.getHeader().selectCategory(category);
        categoryPage.getMenu().selectSubcategory(subcategory);
    }

    @Step("I add products with indexes '{indexes}' to compare list from Yandex Market Product page")
    public List<String> addProductsToCompareListOnYandexMarketProductPage(int... indexes) {
        List<String> titles = new ArrayList<>();
        for (int index : indexes) {
            titles.add(productPage.addToCompare(index));
        }
        productPage.clickCompareButton();
        return titles;
    }
}
