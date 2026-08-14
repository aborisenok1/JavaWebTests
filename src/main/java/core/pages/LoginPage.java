package core.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $x("//*[text()='Sign in']");
    //private SelenideElement forgotPasswordLink = $("[data-l='t'][restore']");
    private SelenideElement forgotPasswordLink = $x("//button[@data-test-id='forgot-password-link']");
    //private SelenideElement registrationButton = $x("//*[text()='\"Sign in\"']");
    private SelenideElement registrationButton = $x("//button[@data-test-id='registration-action']");

    // Локаторы для кнопок соцсетей
    //private SelenideElement vkButton = $("[data-l='t'][vk']");
    private SelenideElement vkButton = $x("//a[@data-l='t,vkc']");
    //private SelenideElement googleButton = $("[data-l='t'][google']"); // исправлено
    private SelenideElement googleButton = $x("//i[@class='i ic social-icon __s __gp']");
    //private SelenideElement mailRuButton = $("[data-l='t'][mailru']"); // исправлено
    private SelenideElement mailRuButton = $x("//i[@class='i ic social-icon __s __mailru']");

    // Локатор для элемента с сообщением об ошибке входа
    //private SelenideElement errorMessage = $(".input-e.login_error");
    private SelenideElement errorMessage = $x("//span[@data-test-id='login-form-error']");


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

    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
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
}