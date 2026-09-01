package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest extends AbstractBaseTest {

    @Override
    protected void configure() {
        //Configuration.remote = "http://localhost:4444/wd/hub";

        if (baseUrl == null || baseUrl.isEmpty()) {
            // Если URL не найден в конфиге, используем значение по умолчанию
            baseUrl = "https://ok.ru";
            System.out.println("Using default URL: " + baseUrl);
        }

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = baseUrl;
        Configuration.timeout = 10000; // 10 секунд таймаут

        System.out.println("Base URL set to: " + baseUrl);

        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--lang=ru-RU");
        chromeOptions.addArguments("--lang=en-US");
        Configuration.browserCapabilities = chromeOptions;

    }
}