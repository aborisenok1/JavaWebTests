package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPage extends BasePage {

    //private SelenideElement recoveryByPhoneButton = $x("//svg[@class='svg-ic svg-ico_phone_24 svg-ic48']");
    private SelenideElement recoveryByPhoneButton = $(byCssSelector("[class='svg-ic svg-ico_phone_24 svg-ic48']"));
    private SelenideElement recoveryByEmailButton = $(byCssSelector("[data-l='t,email']"));
    //private SelenideElement goToSupportButton = $(byCssSelector("[data-l='t,support']"));
    private SelenideElement goToSupportButton = $x("//div[@class='support-link_item-text']");
    private SelenideElement getCodeButtonOnThePhonePage = $x("//input[@class='button-pro __wide js-proceed-registration']");
    private SelenideElement getCodeButtonOnTheEmailPage = $(byCssSelector("[data-l='t,submit']"));
    private SelenideElement phoneField = $x("//input[@tsid='phone-form_input_fe1c7a']");
    private SelenideElement emailField = $(byCssSelector("[id='field_email']"));
    private SelenideElement countryRegionDropDown = $x("//input[@data-popular-locale='Popular']");


    // Конструктор
    public AnonymRecoveryPage() {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
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
}