package ru.levelup.at.selenium.multithreading;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import ru.levelup.at.selenium.page.object.fluent.UserBugRedHomePage;

public class UserBugRedRegistrationTest extends AbstractSeleniumBaseTest {

    private static final Faker FAKER = new Faker();

    @Test
    public void registerUserTest() {
        var expectedUsername = FAKER.name().firstName();

        var userBugRedLoginRegistrationPage = new UserBugRedHomePage(driver.get())
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
}
