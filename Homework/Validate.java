package Homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate implements CheckValidation {

    final private String username;
    final private String password;
    private static final String loginPattern = "(^\\w{1,20}$)";
    private static final String passwordPattern = "(^.{12,20}$)";


    public Validate(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static boolean validateLogin(Validate user) throws BadLoginFormatException {

        String userName = user.getUsername();

        final Matcher matcherUserName = Pattern.compile(loginPattern).matcher(userName);
        if (!matcherUserName.find()) throw new BadLoginFormatException();
        return !matcherUserName.find();
    }

    public static boolean validatePassword(Validate user) throws BadPasswordFormatException {

        String userPassword = user.getPassword();

        final Matcher matcherUserPassword = Pattern.compile(passwordPattern).matcher(userPassword);
        if (!matcherUserPassword.find()) throw new BadPasswordFormatException();
        return !matcherUserPassword.find();
    }

    @Override
    public boolean checkLogin() {
        String userName = getUsername();

        final Matcher matcherUserName = Pattern.compile(loginPattern).matcher(userName);
        return matcherUserName.find();
    }

    @Override
    public boolean checkPassword() {
        String userPassword = getPassword();

        final Matcher matcherUserPassword = Pattern.compile(passwordPattern).matcher(userPassword);
        return matcherUserPassword.find();
    }
}