package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton = $(byCssSelector("[class='svg-ic svg-ico_phone_24 svg-ic48']"));
    private SelenideElement recoveryByEmailButton = $(byCssSelector("[data-l='t,email']"));
    private SelenideElement goToSupportButton = $x("//div[@class='support-link_item-text']");
    private SelenideElement getCodeButtonOnThePhonePage = $x("//input[@class='button-pro __wide js-proceed-registration']");
    private SelenideElement getCodeButtonOnTheEmailPage = $(byCssSelector("[data-l='t,submit']"));
    private SelenideElement phoneField = $x("//input[@tsid='phone-form_input_fe1c7a']");
    private SelenideElement emailField = $(byCssSelector("[id='field_email']"));
    private SelenideElement countryRegionDropDown = $x("//input[@data-popular-locale='Popular']");
    private SelenideElement getCodeButton = $(byCssSelector("[class='button-pro __wide js-proceed-registration']"));
    private SelenideElement incorrectPhoneMessage = $(byCssSelector("[class='input-e js-ph-vl-hint']"));
    private SelenideElement customerSupportTeamButton = $(byCssSelector("[class='support-link_item-text']"));


    // Конструктор
    public AnonymRecoveryPage() {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
        customerSupportTeamButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку восстановления через почту")
    public void goToRecoveryByEmail() {
        recoveryByEmailButton.shouldBe(visible).click();
    }

    @Step("Переходим к технической поддержке")
    public void goToSupport() {
        goToSupportButton.shouldBe(visible).click();
    }

    @Step("Проверка отображения элементов на странице восстановления кредов по телефону")
    public void verifyElementsOnTheRecoveryByPhonePage() {
        getCodeButtonOnThePhonePage.shouldBe(visible);
        phoneField.shouldBe(visible);
        countryRegionDropDown.shouldBe(visible);
    }

    @Step("Проверка отображения элементов на странице восстановления кредов по e-mail-у")
    public void verifyElementsOnTheRecoveryByEmailPage() {
        getCodeButtonOnTheEmailPage.shouldBe(visible);
        emailField.shouldBe(visible);
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryRegionDropDown.click(); // Открываем список стран
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName)); // Находим нужный элемент
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text(); // Прокручиваем к стране и выбираем нужный код
        countryItem.click();
        return countryCode;
    }

    @Step("Нажимает кнопку \"Get code\" и проверяем сообщение об ошибке")
    public void getCodeButtonClickAndCheckErrorMessage() {
        getCodeButton.shouldBe(visible).click();
        incorrectPhoneMessage.shouldBe(visible);
        assertEquals("Incorrect phone number.", incorrectPhoneMessage.text());
    }

    @Step("Проверяем наличие элементов на странице восстановления")
    public void checkPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
        customerSupportTeamButton.shouldBe(visible);
    }
}