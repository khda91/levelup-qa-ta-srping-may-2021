package ru.levelup.at.selenium.page.object.page.composite.component;

import java.util.List;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.at.selenium.page.object.page.composite.AbstractPageComponent;

public class YandexMarketHeaderComponent extends AbstractPageComponent {

    @FindBy(css = "[data-zone-name='category-link'] span")
    private List<WebElement> categoriesMenuItems;

    @FindBy(id = "header-search")
    private WebElement searchTextField;

    @FindBy(xpath = "//span[text() = 'Найти']")
    private WebElement searchButton;

    public YandexMarketHeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void selectCategory(final String categoryName) {
        Optional<WebElement> category = categoriesMenuItems
            .stream()
            .filter(categoriesMenuItem -> categoriesMenuItem.getText().equalsIgnoreCase(categoryName))
            .findFirst();

        category.ifPresent(WebElement::click);
    }

    public void enterSearchText(final String searchText) {
        searchTextField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        waitElementIsClickable(searchButton).click();
    }
}
