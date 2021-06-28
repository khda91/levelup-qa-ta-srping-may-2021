package ru.levelup.at.selenium.page.object.page.composite;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.selenium.page.object.page.composite.component.YandexMarketHeaderComponent;

public abstract class AbstractPage extends AbstractPageComponent {

    private static final String URL = "https://market.yandex.ru";

    protected YandexMarketHeaderComponent headerComponent;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        headerComponent = new YandexMarketHeaderComponent(driver);
    }

    protected void open(String url) {
        driver.navigate().to(URL + url);
    }

    public YandexMarketHeaderComponent getHeader() {
        return headerComponent;
    }
}
