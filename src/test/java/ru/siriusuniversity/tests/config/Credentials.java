package ru.siriusuniversity.tests.config;

import io.github.cdimascio.dotenv.Dotenv;

public final class Credentials {

    private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load();

    public static final String LOGIN    = DOTENV.get("LKS_LOGIN", "");
    public static final String PASSWORD = DOTENV.get("LKS_PASSWORD", "");

    public static boolean isAvailable() {
        return !LOGIN.isEmpty() && !PASSWORD.isEmpty();
    }

    private Credentials() {
    }
}
