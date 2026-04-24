# max-tests

UI-автотест для проверки кнопки «Вход» на сайте Университета Сириус через поиск Google.

## Стек

- Java 17
- Maven
- JUnit 5
- Selenide 7.x (управляет драйвером Chrome автоматически через Selenium Manager)

## Структура проекта

```
max-tests/
├── pom.xml
└── src/test/java/ru/siriusuniversity/tests/
    ├── base/
    │   └── BaseTest.java                  // инициализация/закрытие браузера
    ├── config/
    │   └── WebDriverConfig.java           // настройки Selenide (browser, size, timeouts)
    ├── pages/
    │   ├── GoogleSearchPage.java          // Page Object: поисковая страница Google
    │   └── SiriusUniversityPage.java      // Page Object: главная страница университета
    └── SiriusUniversityTest.java          // тест на отображение кнопки «Вход»
```

## Требования

- JDK 17+
- Maven 3.8+
- Установленный браузер Google Chrome

## Запуск

Все тесты:
```
mvn test
```

Headless-режим:
```
mvn test -Dselenide.headless=true
```

## Что проверяет тест

`SiriusUniversityTest#loginButtonIsDisplayedOnUniversityPage`:
1. открывает `https://www.google.com` в Chrome;
2. вводит «Университет Сириус» в поисковую строку и нажимает Enter;
3. кликает по результату поиска с заголовком, содержащим «Сириус»;
4. на открывшейся странице университета проверяет, что кнопка «Вход» видима.

## Отчёты и скриншоты

Скриншоты неудачных шагов сохраняются в `target/selenide-reports/`.
