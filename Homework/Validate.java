
// Внес правки по замечанию "используйте Pattern, и компилируйте выражение единожды"

package Homework;

import java.util.regex.Pattern;

class Validate implements CheckValidation {
    private final String login;
    private final String password;
    private final Pattern loginPattern;
    private final Pattern passwordPattern;

    public Validate(String login, String password) {
        this.login = login;
        this.password = password;
        loginPattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
        passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$");
    }

    // Проверка логина
    public static boolean validateLogin(Validate validate) throws BadLoginFormatException {
        if (!validate.checkLogin()) {
            throw new BadLoginFormatException("Логин должн быть правильным");
        } else {
            return true;
        }
    }

    // Проверка пароля
    public static boolean validatePassword(Validate validate) throws BadPasswordFormatException {
        if (!validate.checkPassword()) {
            throw new BadPasswordFormatException("Пароль должн быть правильным");
        } else {
            return true;
        }
    }

}