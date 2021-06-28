package ru.levelup.at.selenium.allure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractPageComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitElementIsClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitElementIsClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
