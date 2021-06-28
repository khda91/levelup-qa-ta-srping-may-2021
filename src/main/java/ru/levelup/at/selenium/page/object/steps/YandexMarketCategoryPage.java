package ru.levelup.at.selenium.page.object.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.selenium.page.object.steps.component.YandexMarketLeftSideMenuComponent;

public class YandexMarketCategoryPage extends AbstractPage {

    private YandexMarketLeftSideMenuComponent menuComponent;

    public YandexMarketCategoryPage(WebDriver driver) {
        super(driver);
        menuComponent = new YandexMarketLeftSideMenuComponent(driver);
    }

    public YandexMarketLeftSideMenuComponent getMenu() {
        return menuComponent;
    }
}
