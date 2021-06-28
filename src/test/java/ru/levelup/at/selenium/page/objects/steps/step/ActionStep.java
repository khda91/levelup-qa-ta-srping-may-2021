package ru.levelup.at.selenium.page.objects.steps.step;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    public void openYandexMarketIndexPage() {
        indexPage.open();
    }

    public void searchProductOnYandexMarket(final String productTitle) {
        indexPage.getHeader().enterSearchText(productTitle);
        indexPage.getHeader().clickSearchButton();
        ;
    }

    public void selectCategoryAndSubcategoryOnYandexMarket(final String category, final String subcategory) {
        indexPage.getHeader().selectCategory(category);
        categoryPage.getMenu().selectSubcategory(subcategory);
    }

    public List<String> addProductsToCompareListOnYandexMarketProductPage(int... indexes) {
        List<String> titles = new ArrayList<>();
        for (int index : indexes) {
            titles.add(productPage.addToCompare(index));
        }
        productPage.clickCompareButton();
        return titles;
    }
}
