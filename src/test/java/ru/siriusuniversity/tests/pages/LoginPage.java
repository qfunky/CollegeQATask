package ru.siriusuniversity.tests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.siriusuniversity.tests.config.Credentials;
import ru.siriusuniversity.tests.config.WebDriverConfig;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final String LOGIN_BUTTON_TEXT = "Войти";

    private final SelenideElement loginButton =
            $(byXpath("//button[@type='submit' and normalize-space(text())='" + LOGIN_BUTTON_TEXT + "']"));
    private final SelenideElement emailInput = $("input[name='login']");
    private final SelenideElement passwordInput = $("input[name='password']");

    public LoginPage openPage() {
        Selenide.open(WebDriverConfig.LOGIN_PATH);
        return this;
    }

    public LoginPage verifyLoginButtonIsDisplayed() {
        loginButton.shouldBe(visible);
        loginButton.shouldBe(enabled);
        loginButton.shouldHave(exactText(LOGIN_BUTTON_TEXT));
        return this;
    }

    public DashboardPage login() {
        emailInput.shouldBe(visible).setValue(Credentials.LOGIN);
        passwordInput.shouldBe(visible).setValue(Credentials.PASSWORD);
        loginButton.click();
        return new DashboardPage();
    }
}
