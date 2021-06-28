package ru.levelup.at.selenium.page.object.page.composite.component;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.at.selenium.page.object.page.composite.AbstractPageComponent;

public class YandexMarketLeftSideMenuComponent extends AbstractPageComponent {

    @FindBy(css = "[data-zone-name='link'] a")
    private List<WebElement> subcategoryMenuItems;

    public YandexMarketLeftSideMenuComponent(WebDriver driver) {
        super(driver);
    }

    public void selectSubcategory(final String subcategoryName) {
        waitElementIsClickable(By.linkText(subcategoryName)).click();
    }
}
