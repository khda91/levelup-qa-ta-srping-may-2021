package ru.levelup.at.selenium.page.object.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedHomePage extends AbstractBasePage {

    @FindBy(xpath = "//span[text() = 'Войти']")
    private WebElement loginButton;

    @FindBy(css = "a[data-toggle='dropdown']")
    private WebElement usernameDropdown;

    public UserBugRedHomePage(WebDriver driver) {
        super(driver);
    }

    public UserBugRedHomePage open() {
        open("");
        return this;
    }

    public UserBugRedLoginRegistrationPage clickLoginButton() {
        waitElementIsVisible(loginButton).click();
        return new UserBugRedLoginRegistrationPage(driver);
    }

    public String getUsernameText() {
        return usernameDropdown.getText();
    }
}
