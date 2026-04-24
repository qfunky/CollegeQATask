# CollegeQATask

UI-автотест на Java + JUnit 5 + Selenide: проверка страницы входа в личный кабинет Университета Сириус.

## Стек

- Java 21
- Maven
- JUnit 5
- Selenide 7.x (управляет драйвером Chrome автоматически через Selenium Manager)
- dotenv-java (чтение учётных данных из `.env`)

## Структура проекта

```
CollegeQATask/
├── .env                  ← создай сам, в git не попадает
├── .gitignore
├── pom.xml
└── src/test/java/ru/siriusuniversity/tests/
    ├── base/
    │   └── BaseTest.java              // инициализация Chrome, закрытие после теста
    ├── config/
    │   ├── Credentials.java           // читает LKS_LOGIN и LKS_PASSWORD из .env
    │   └── WebDriverConfig.java       // настройки Selenide (browser, size, timeouts)
    ├── pages/
    │   ├── DashboardPage.java         // проверка успешного входа (URL ушёл с /login)
    │   └── LoginPage.java             // Page Object страницы логина
    └── LoginPageTest.java             // сам тест
```

## Настройка учётных данных

Создай файл `.env` в корне проекта:

```
LKS_LOGIN=your_email@example.com
LKS_PASSWORD=your_password
```

Файл `.env` не попадает в git — он добавлен в `.gitignore`.

## Запуск

```bash
mvn test
```

Headless-режим (без открытия окна браузера):

```bash
mvn test -Dselenide.headless=true
```

## Что делает тест

`LoginPageTest` открывает `https://lks.siriusuniversity.ru/login` и:

| Условие | Сценарий |
|---|---|
| `.env` **есть** с данными | кнопка «Войти» видна → вводит логин/пароль → кликает → проверяет, что URL ушёл с `/login` |
| `.env` **нет** или пустой | кнопка «Войти» видна → кликает без данных → проверяет, что страница осталась на `/login` |

## Отчёты и скриншоты

Скриншоты неудачных шагов сохраняются в `target/selenide-reports/`.
