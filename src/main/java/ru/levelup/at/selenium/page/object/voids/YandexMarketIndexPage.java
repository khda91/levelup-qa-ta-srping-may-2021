package ru.levelup.at.selenium.page.object.voids;

import java.util.List;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMarketIndexPage extends AbstractBasePage {

    @FindBy(css = "[data-zone-name='category-link'] span")
    private List<WebElement> categoriesMenuItems;

    public YandexMarketIndexPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }

    public void selectCategory(final String categoryName) {
        Optional<WebElement> category = categoriesMenuItems
            .stream()
            .filter(categoriesMenuItem -> categoriesMenuItem.getText().equalsIgnoreCase(categoryName))
            .findFirst();

        category.ifPresent(WebElement::click);
        //        for (WebElement categoriesMenuItem : categoriesMenuItems) {
        //            if (categoriesMenuItem.getText().equals(categoryName)) {
        //                categoriesMenuItem.click();
        //                break;
        //            }
        //        }
    }
}
