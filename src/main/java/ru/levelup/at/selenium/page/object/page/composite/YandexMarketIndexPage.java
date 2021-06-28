package ru.levelup.at.selenium.page.object.page.composite;

import org.openqa.selenium.WebDriver;

public class YandexMarketIndexPage extends AbstractPage {

    public YandexMarketIndexPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("/");
    }
}
