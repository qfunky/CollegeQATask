package ru.siriusuniversity.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.siriusuniversity.tests.base.BaseTest;
import ru.siriusuniversity.tests.pages.LoginPage;

@DisplayName("Страница входа Университета Сириус")
public class LoginPageTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Вход в личный кабинет: кнопка отображается и после нажатия открывается личный кабинет")
    void loginButtonIsDisplayedAndLoginSucceeds() {
        loginPage
                .openPage()
                .verifyLoginButtonIsDisplayed()
                .login()
                .verifyPageLoaded();
    }
}
