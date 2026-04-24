package ru.siriusuniversity.tests.base;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.siriusuniversity.tests.config.WebDriverConfig;

/**
 * Базовый класс для всех UI-тестов.
 * Отвечает за инициализацию Selenide и корректное закрытие браузера.
 */
public abstract class BaseTest {

    @BeforeAll
    static void setUpAll() {
        WebDriverConfig.setUp();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
