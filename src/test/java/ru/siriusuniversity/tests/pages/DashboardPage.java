package ru.siriusuniversity.tests.pages;

import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static com.codeborne.selenide.Selenide.webdriver;

public class DashboardPage {

    public DashboardPage verifyPageLoaded() {
        webdriver().shouldNotHave(urlContaining("/login"));
        return this;
    }
}
