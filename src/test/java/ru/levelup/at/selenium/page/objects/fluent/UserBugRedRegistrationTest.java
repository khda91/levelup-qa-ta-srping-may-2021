package ru.levelup.at.selenium.page.objects.fluent;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import ru.levelup.at.selenium.page.object.fluent.UserBugRedHomePage;

public class UserBugRedRegistrationTest extends AbstractSeleniumBaseTest {

    private static final Faker FAKER = new Faker();

    @Test
    public void registerUserTest() {
        var expectedUsername = FAKER.name().firstName();

        var userBugRedLoginRegistrationPage = new UserBugRedHomePage(driver)
            .open()
            .clickLoginButton();

        var userBugRedHomePage = userBugRedLoginRegistrationPage
            .enterName(expectedUsername)
            .enterEmail(FAKER.internet().emailAddress())
            .enterPassword(FAKER.internet().password())
            .clickSuccessRegisterButton();

        var actualUsername = userBugRedHomePage.getUsernameText();

        assertThat(actualUsername)
            .as("Incorrect user name was displayed")
            .isEqualToIgnoringCase(expectedUsername);
    }

    @Test
    public void registerChainUserTest() {
        var expectedUsername = FAKER.name().firstName();

        var actualUsername = new UserBugRedHomePage(driver)
            .open()
            .clickLoginButton()
            .enterName(expectedUsername)
            .enterEmail(FAKER.internet().emailAddress())
            .enterPassword(FAKER.internet().password())
            .clickSuccessRegisterButton()
            .getUsernameText();

        assertThat(actualUsername)
            .as("Incorrect user name was displayed")
            .isEqualToIgnoringCase(expectedUsername);
    }

    @Test
    public void registerVoidUserTest() {
        var expectedUsername = FAKER.name().firstName();

        var userBugRedLoginRegistrationPage = new UserBugRedHomePage(driver)
            .open()
            .clickLoginButton();

        userBugRedLoginRegistrationPage.enterName(expectedUsername);
        userBugRedLoginRegistrationPage.enterEmail(FAKER.internet().emailAddress());
        userBugRedLoginRegistrationPage.enterPassword(FAKER.internet().password());

        var userBugRedHomePage = userBugRedLoginRegistrationPage.clickSuccessRegisterButton();

        var actualUsername = userBugRedHomePage.getUsernameText();

        assertThat(actualUsername)
            .as("Incorrect user name was displayed")
            .isEqualToIgnoringCase(expectedUsername);
    }

    @Test
    public void negativeRegisterUserTest() {
        var expectedUsername = "testdddddddd";

        var userBugRedLoginRegistrationPage = new UserBugRedHomePage(driver)
            .open()
            .clickLoginButton();

        var actualErrorMessage = userBugRedLoginRegistrationPage
            .enterName(expectedUsername)
            .enterEmail(FAKER.internet().emailAddress())
            .enterPassword(FAKER.internet().password())
            .clickFailRegisterButton()
            .getErrorMessageLabelText();

        assertThat(actualErrorMessage)
            .as("Registration was successful")
            .isEqualToIgnoringCase("register_busy (name)");
    }
}
