package ru.levelup.at.selenium.page.object.voids;

import static org.openqa.selenium.By.cssSelector;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class YandexMarketProductPage extends AbstractBasePage {

    @FindBy(css = "[data-autotest-id='product-snippet']")
    private List<WebElement> productCards;

    @FindBy(xpath = ".//span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketProductPage(WebDriver driver) {
        super(driver);
    }

    public String addProductToCompareList(int productIndex) {
        var productCard = productCards.get(productIndex - 1);
        var productCardTitle = productCard.findElement(cssSelector("h3[data-zone-name='title'] span"))
                                          .getText();

        var addToCompareButton = productCard.findElement(By.xpath(".//div[contains(@aria-label, 'сравнению')]"));

        new Actions(driver)
            .moveToElement(addToCompareButton)
            .click()
            .perform();

        return productCardTitle;
    }

    public void clickCompareButton() {
        waitElementIsVisible(compareButton).click();
        //        new Actions(driver)
        //            .moveToElement(compareButton)
        //            .click()
        //            .perform();
    }
}
