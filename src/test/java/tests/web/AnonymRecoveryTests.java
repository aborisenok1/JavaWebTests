package tests.web;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class AnonymRecoveryTests extends BaseTest {

    private AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
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
    public void anonymRecoveryTestByPhone() {

        // Переходим к восстановлению профиля по телефону
        open("https://ok.ru/dk?st.cmd=anonymRecoveryStart");
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        anonymRecoveryPage.verifyElementsOnTheRecoveryByPhonePage();

        String countryCode = anonymRecoveryPage.selectCountryByName("Poland");
        assertEquals("+48", countryCode, "Код страны не совпадает с ожидаемым");
        anonymRecoveryPage.getCodeButtonClickAndCheckErrorMessage();
    }
}