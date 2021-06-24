package ru.levelup.at.selenium.page.object.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedLoginRegistrationPage extends AbstractBasePage {

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    private WebElement nameTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@value='Зарегистрироваться']")
    private WebElement registerButton;

    @FindBy(xpath = "//form[contains(@action, 'register')]//p")
    private WebElement errorMessageLabel;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public UserBugRedLoginRegistrationPage enterName(final String name) {
        this.nameTextField.sendKeys(name);
        return this;
    }

    public UserBugRedLoginRegistrationPage enterEmail(final String email) {
        this.emailTextField.sendKeys(email);
        return this;
    }

    public UserBugRedLoginRegistrationPage enterPassword(final String password) {
        this.passwordTextField.sendKeys(password);
        return this;
    }

    public UserBugRedHomePage clickSuccessRegisterButton() {
        waitElementIsVisible(registerButton).click();
        return new UserBugRedHomePage(driver);
    }

    public UserBugRedLoginRegistrationPage clickFailRegisterButton() {
        waitElementIsVisible(registerButton).click();
        return this;
    }

    public void clickRegisterButton() {
        waitElementIsVisible(registerButton).click();
    }

    public String getErrorMessageLabelText() {
        return errorMessageLabel.getText();
    }
}
