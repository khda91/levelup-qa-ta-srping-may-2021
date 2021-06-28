package ru.levelup.at.selenium.allure;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.at.selenium.allure.component.YandexMarketProductCardComponent;

public class YandexMarketProductPage extends AbstractPage {

    @FindBy(css = "article[data-autotest-id='product-snippet']")
    private List<WebElement> productCards;

    @FindBy(xpath = ".//span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketProductPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductTitles() {
        return productCards.stream()
                           .map(productCard -> new YandexMarketProductCardComponent(driver, productCard))
                           .map(YandexMarketProductCardComponent::getTitle)
                           .collect(Collectors.toList());
    }

    public String addToCompare(int productIndex) {
        var productCard = new YandexMarketProductCardComponent(driver, productCards.get(productIndex - 1));
        productCard.addToCompareList();
        return productCard.getTitle();
    }

    public void clickCompareButton() {
        waitElementIsClickable(compareButton).click();
    }
}
