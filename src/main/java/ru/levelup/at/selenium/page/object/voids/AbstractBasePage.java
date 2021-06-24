package ru.levelup.at.selenium.page.object.voids;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePage {

    private static final String BASE_URL = "https://market.yandex.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }

    protected WebElement waitElementIsVisible(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        var webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webElement;
    }

    protected WebElement waitElementIsVisible(WebElement element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        var webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webElement;
    }
}
