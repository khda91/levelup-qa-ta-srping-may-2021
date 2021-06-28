package ru.levelup.at.selenium.page.object.steps;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMarketComparePage extends AbstractPage {

    @FindBy(css = "div[data-tid='412661c'] a")
    private List<WebElement> compareProductsTitleList;

    public YandexMarketComparePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getComparedProductTitles() {
        return compareProductsTitleList
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
