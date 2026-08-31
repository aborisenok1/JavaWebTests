package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.AnonymRecoveryMobileScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryMobileTests extends MobileBaseTest {

    private AnonymRecoveryMobileScreen anonymRecoveryMobileScreen;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
    }

    @Test
    public void anonymRecoveryByEmailMobileTest() {
        anonymRecoveryMobileScreen = new AnonymRecoveryMobileScreen();
        open("https://ok.ru/dk?st.cmd=anonymRecoveryStart");
        anonymRecoveryMobileScreen.goToRecoveryByEmail();
        anonymRecoveryMobileScreen.verifyElementsOnTheRecoveryByEmailPage();
    }

    @Test
    public void anonymRecoveryTestByPhoneMobileTest() {
        open("https://ok.ru/dk?st.cmd=anonymRecoveryStart");
        anonymRecoveryMobileScreen = new AnonymRecoveryMobileScreen();
        anonymRecoveryMobileScreen.goToRecoveryByPhone();
        anonymRecoveryMobileScreen.verifyElementsOnTheRecoveryByPhonePage();
        String countryCode = anonymRecoveryMobileScreen.selectCountryByName("Poland");
        assertEquals("+48", countryCode, "Код страны не совпадает с ожидаемым");
        anonymRecoveryMobileScreen.getCodeButtonClickAndCheckErrorMessage();
    }
}