
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

    public boolean checkLogin() throws Exception {
        Matcher matcher = loginPattern.matcher(login);
        if (!matcher.matches()) {
            throw new Exception("Invalid login");
        }
        return true;
    }

    public boolean checkPassword() throws Exception {
        Matcher matcher = passwordPattern.matcher(password);
        if (!matcher.matches()) {
            throw new Exception("Invalid password");
        }
        return true;
    }

}