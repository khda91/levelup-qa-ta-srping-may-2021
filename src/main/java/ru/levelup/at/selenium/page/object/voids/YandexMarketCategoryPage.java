package ru.levelup.at.selenium.page.object.voids;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMarketCategoryPage extends AbstractBasePage {

    @FindBy(css = "[data-zone-name='link'] a")
    private List<WebElement> subcategoryMenuItems;

    public YandexMarketCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void selectSubcategory(final String subcategoryName) {
        waitElementIsVisible(By.linkText(subcategoryName)).click();
        // Получили StaleElementReferenceException
        // driver.findElement(By.linkText(subcategoryName)).click();

        //        try {
        //            subcategoryMenuItems.stream()
        //                                .filter(webElement -> webElement.getText().equals(subcategoryName))
        //                                .findFirst()
        //                                .ifPresent(WebElement::click);
        //        } catch (StaleElementReferenceException e) {
        //            subcategoryMenuItems.stream()
        //                                .filter(webElement -> webElement.getText().equals(subcategoryName))
        //                                .findFirst()
        //                                .ifPresent(WebElement::click);
        //        }
    }
}
