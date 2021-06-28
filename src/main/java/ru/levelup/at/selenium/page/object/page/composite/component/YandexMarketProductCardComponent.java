package ru.levelup.at.selenium.page.object.page.composite.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.levelup.at.selenium.page.object.page.composite.AbstractPageComponent;

public class YandexMarketProductCardComponent extends AbstractPageComponent {

    private static final String TITLE_LINK_CSS_SELECTOR = "h3[data-zone-name='title'] > a";
    private static final String ADD_TO_COMPARE_LIST_BUTTON_XPATH = ".//div[contains(@aria-label, 'сравнению')]";

    private final WebElement root;

    public YandexMarketProductCardComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public String getTitle() {
        var titleLink = root.findElement(By.cssSelector(TITLE_LINK_CSS_SELECTOR));
        return titleLink.getAttribute("title");
    }

    public void addToCompareList() {
        var addToCompareButton = root.findElement(By.xpath(ADD_TO_COMPARE_LIST_BUTTON_XPATH));

        new Actions(driver)
            .moveToElement(addToCompareButton)
            .click()
            .perform();
    }
}
