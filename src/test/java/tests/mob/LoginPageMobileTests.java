package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.LoginMobileScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginPageMobileTests extends MobileBaseTest {
    private static LoginMobileScreen loginMobileScreen;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        // Принятие cookies и политики
        loginMobileScreen = new LoginMobileScreen();
    }

    @Test
    public void loginWithWrongCredentials() {
        loginMobileScreen.verifyPageElements();
        loginMobileScreen.login("incorrectUser");
        loginMobileScreen.password("incorrectPassword");
        loginMobileScreen.click();

        // Проверка наличия сообщения об ошибке
        loginMobileScreen.errorMessageShouldBeVisible();
        assertTrue(loginMobileScreen.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Неправильно указан логин и/или пароль";
        String actualErrorMessage = loginMobileScreen.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginWithWrongLoginAndBlankPassword() {
        loginMobileScreen.verifyPageElements();
        loginMobileScreen.password("incorrectPassword");
        loginMobileScreen.click();

        // Проверка наличия сообщения об ошибке
        loginMobileScreen.errorMessageShouldBeVisible();
        assertTrue(loginMobileScreen.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage3 = "Login required";
        String actualErrorMessage3 = loginMobileScreen.getErrorMessageText();
        assertEquals(expectedErrorMessage3, actualErrorMessage3, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginWithBlankLoginAndWrongPassword() {
        loginMobileScreen.verifyPageElements();
        loginMobileScreen.password("incorrectPassword");
        loginMobileScreen.click();

        // Проверка наличия сообщения об ошибке
        loginMobileScreen.errorMessageShouldBeVisible();
        assertTrue(loginMobileScreen.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage3 = "Login required";
        String actualErrorMessage3 = loginMobileScreen.getErrorMessageText();
        assertEquals(expectedErrorMessage3, actualErrorMessage3, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void customerSupportTeamPopupTest() {
        loginMobileScreen.verifyPageElements();
        loginMobileScreen.cantSignInButtonClick();
        loginMobileScreen.contactCustomerSupportTeamButtonClick();
        loginMobileScreen.contactCustomerSupportTeamElementsCheck();
        loginMobileScreen.closeCrossButtonClick();
        loginMobileScreen.contactCustomerSupportTeamShouldNotBeDisplayedCheck();
    }

    @Test
    //@RetryingTest(maxAttempts = 3)
    public void groupsSearchTest(){
        loginMobileScreen.verifyPageElements();
        loginMobileScreen.enterDataInSearchFieldAndClickSearchButton("Тестировщик");
    }
}