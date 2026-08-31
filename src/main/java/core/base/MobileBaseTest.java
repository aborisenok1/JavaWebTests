package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class MobileBaseTest extends AbstractBaseTest {
    @Override
    protected void configure() {
        // ... ваша настройка браузера
        Configuration.browser = "chrome";
        Configuration.timeout = 10000; // 10 секунд таймаут
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone XR"));
        Configuration.browserCapabilities = chromeOptions;

        // Установите реальный URL вашего тестового стенда
        baseUrl = "https://ok.ru";

    }
}


