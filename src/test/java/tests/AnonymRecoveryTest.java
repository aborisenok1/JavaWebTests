package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

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
    public void anonymRecoveryTestByEmail() {

        // Переходим к восстановлению профиля по e-mail-у
        open("https://ok.ru/dk?st.cmd=anonymRecoveryStart");
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();
        anonymRecoveryPage.verifyElementsOnTheRecoveryByEmailPage();
    }

    @Test
    public void anonymRecoveryTestByPhone() throws InterruptedException {

        // Переходим к восстановлению профиля по телефону
        open("https://ok.ru/dk?st.cmd=anonymRecoveryStart");
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        anonymRecoveryPage.verifyElementsOnTheRecoveryByPhonePage();
        Thread.sleep(1000);

        String countryCode = anonymRecoveryPage.selectCountryByName("Poland");
        assertEquals("+48", countryCode, "Код страны не совпадает с ожидаемым");
        Thread.sleep(1000); // добавил чисто ради удобства визуального восприятия :)
        anonymRecoveryPage.getCodeButtonClickAndCheckErrorMessage();
        Thread.sleep(1000);
    }
}