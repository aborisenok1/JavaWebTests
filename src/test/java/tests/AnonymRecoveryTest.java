package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRecoveryTest extends BaseTest {

    private LoginPage loginPage;
    private AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);

        // Принятие cookies и политики
        loginPage = new LoginPage();
//        loginPage.acceptCookie();
//        loginPage.acceptPrivacyButton();
    }

    @Test
    public void anonymRecoveryTestByPhone() {

        // >>>!!!При множественных попытках глючит переход на страницу выбора способа восстановления!!!<<<
        //Сделал прямой ссылкой. Для теста в рамках обучения норм :)


/*
        // Попытка входа с некорректными данными
        //loginPage.loginAndPassword("incorrectUser", "incorrectPassword");

        // Вводим неверный пароль несколько раз
        for (int i = 0; i < 3; i++) {
            //loginPage.login("1");
            loginPage.clickLogin();
        }
*/


        // Переходим к восстановлению профиля по телефону
        open("https://ok.ru/dk?st.cmd=anonymRecoveryStart");
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        anonymRecoveryPage.verifyElementsOnTheRecoveryByPhonePage();
    }

    @Test
    public void anonymRecoveryTestByEmail() {

        // Переходим к восстановлению профиля по e-mail-у
        open("https://ok.ru/dk?st.cmd=anonymRecoveryStart");
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();
        anonymRecoveryPage.verifyElementsOnTheRecoveryByEmailPage();
    }
}