package ru.levelup.at.selenium.page.object.steps;

import org.openqa.selenium.WebDriver;

public class YandexMarketIndexPage extends AbstractPage {

    public YandexMarketIndexPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("/");
    }
}
