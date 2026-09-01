package core.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest extends AbstractBaseTest {

    @Override
    protected void configure() {

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

    }
}