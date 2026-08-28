package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginPageTests extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        // Принятие cookies и политики
        loginPage = new LoginPage();
    }

    @Test
    public void loginWithWrongCredentials() {
        // Попытка входа с некорректными данными
        loginPage.login("incorrectUser");
        loginPage.password("incorrectPassword");
        loginPage.click();

        // Проверка наличия сообщения об ошибке
        loginPage.errorMessageShouldBeVisible();
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Неправильно указан логин и/или пароль";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginWithWrongLoginAndBlankPassword() {
        loginPage.password("incorrectPassword");
        loginPage.click();

        // Проверка наличия сообщения об ошибке
        loginPage.errorMessageShouldBeVisible();
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage3 = "Login required";
        String actualErrorMessage3 = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage3, actualErrorMessage3, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginWithBlankLoginAndWrongPassword() {
        loginPage.password("incorrectPassword");
        loginPage.click();

        // Проверка наличия сообщения об ошибке
        loginPage.errorMessageShouldBeVisible();
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage3 = "Login required";
        String actualErrorMessage3 = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage3, actualErrorMessage3, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void verifyQrCodeAndOtherElementsVisibility() throws InterruptedException {
        loginPage.qRCodeButtonClick();
        loginPage.qRCodePageElementsCheck();
    }

    @Test
    public void customerSupportTeamPopupTest() {
        loginPage.cantSignInButtonClick();
        loginPage.contactCustomerSupportTeamButtonClick();
        loginPage.contactCustomerSupportTeamElementsCheck();
        loginPage.closeCrossButtonClick();
        loginPage.contactCustomerSupportTeamShouldNotBeDisplayedCheck();
    }

    @Test
    public void groupsSearchTest() throws InterruptedException {
        loginPage.enterDataInSearchFieldAndClickSearchButton("Тестировщик");
    }
}