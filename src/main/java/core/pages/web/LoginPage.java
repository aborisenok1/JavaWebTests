package core.pages.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $x("//*[text()='Sign in']");
    private SelenideElement forgotPasswordLink = $x("//button[@data-test-id='forgot-password-link']");
    private SelenideElement registrationButton = $x("//button[@data-test-id='registration-action']");

    // Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $x("//a[@data-l='t,vkc']");
    private SelenideElement googleButton = $x("//i[@class='i ic social-icon __s __gp']");
    private SelenideElement mailRuButton = $x("//i[@class='i ic social-icon __s __mailru']");

    // Локатор для элемента с сообщением об ошибке входа
    private SelenideElement errorMessage = $x("//span[@data-test-id='login-form-error']");

    // Локатор для перехода к восстановлению
    private SelenideElement goToRecoveryButton = $("[data-test-id='recovery-action']");

    private SelenideElement qRCodeButton = $("[data-l='t,qr_tab']");
    private SelenideElement getACodeForQuickLogInToOK = $("[class='qr_code_info_header']");
    private SelenideElement textBlock = $("[class='qr_code_info_instruction_list']");
    private SelenideElement yourAuthorizationCodeText = $("[class='qr_code_info_digest_info']");
    private SelenideElement qRCode = $("[class='qr_code_image_wrapper']");
    private SelenideElement cantSignInButton = $("[data-test-id='forgot-password-link']");
    private SelenideElement contactCustomerSupportTeamButton = $("[class='support-link_item-text']");
    private SelenideElement sendMessageButton = $("[class='form-actions_yes button-pro js-submit']");
    private SelenideElement closeCrossButton = $("[class='ic modal-new_close_ico']");
    private SelenideElement searchFieldInHeader = $("[name='st.query']");
    private SelenideElement groupList = $x("//a[@href=\"/groups\" and @data-active=\"true\"]");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        googleButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        qRCodeButton.shouldBe(visible);
        cantSignInButton.shouldBe(visible);
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Восстановить профиль")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Ожидание отображения ошибки")
    public void errorMessageShouldBeVisible() {
        errorMessage.shouldBe(visible).click();
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.isDisplayed();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Вводин на сайте логин: {username} и пароль: {password}")
    public void loginAndPassword(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Вводин на сайте логин: {username}")
    public void login(String username) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
    }

    @Step("Вводин на сайте пароль: {password}")
    public void password(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Делаем клин по кнопке логина")
    public void click() {
        loginButton.shouldBe(visible).click();
        usernameField.shouldBe(visible).clear();
        passwordField.shouldBe(visible).clear();
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(Condition.visible).click();
    }

    // Методы для перехода на страницы авторизации через соцсети
    @Step("Входим на сайт через ВКонтакте")
    public void loginWithVK() {
        vkButton.shouldBe(Condition.visible).click();
    }

    @Step("Входим на сайт через Google")
    public void loginWithGoogle() {
        googleButton.shouldBe(Condition.visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    public void loginWithMailRu() {
        mailRuButton.shouldBe(Condition.visible).click();
    }

    @Step("Нажимаем кнопку Can't sign in?")
    public void cantSignInButtonClick() {
        cantSignInButton.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Contact Customer Support Team")
    public void contactCustomerSupportTeamButtonClick() {
        contactCustomerSupportTeamButton.shouldBe(visible).click();
    }

    @Step("Кликнуть QR Code button")
    public void qRCodeButtonClick() {
        qRCodeButton.shouldBe(visible).click();
    }

    @Step("Закрыть модальное окно")
    public void closeCrossButtonClick() {
        sleep(1000);
        closeCrossButton.shouldBe(visible).click();
    }

    @Step("Проверка отображения элементов на QR Code странице")
    public void qRCodePageElementsCheck() {
        qRCodeButton.shouldBe(visible).click();
        getACodeForQuickLogInToOK.shouldBe(visible);
        assertEquals("Get a code for quick log in to OK", getACodeForQuickLogInToOK.text());
        assertTrue(textBlock.text().contains("Open your phone camera and scan this QR code"));
        assertTrue(textBlock.text().contains("Follow the link that opens"));
        assertTrue(textBlock.text().contains("Check the authorization code below and confirm log in"));
        yourAuthorizationCodeText.shouldBe(visible);
        assertTrue(yourAuthorizationCodeText.text().contains("Your authorization code: "));
        qRCode.shouldBe(visible);
    }

    @Step("Проверка отображения элементов на странице 'Contact the Customer Support Team'")
    public void contactCustomerSupportTeamElementsCheck() {
        sendMessageButton.shouldBe(visible);
        closeCrossButton.shouldBe(visible);
    }

    @Step("Проверка отсутствия отображения модального окна 'Contact the Customer Support Team' на странице")
    public void contactCustomerSupportTeamShouldNotBeDisplayedCheck() {
        sendMessageButton.shouldNotBe(visible);
        closeCrossButton.shouldNotBe(visible);
    }

    @Step("Ввести в поле поиска и начать Search button")
    public void enterDataInSearchFieldAndClickSearchButton(String text) {
        searchFieldInHeader.should(visible).click();
        searchFieldInHeader.should(visible).setValue(text).pressEnter();
        groupList.shouldBe(visible);
        assertTrue(groupList.getAttribute("data-active").contains("true"));
    }
}