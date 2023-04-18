package Homework;

import static Homework.Validate.validateLogin;
import static Homework.Validate.validatePassword;

public class Program {

    public static void main(String[] args) {

        System.out.println("Проверка логина:");
        Validate loginTest = new Validate("tdr5656rr", "126@$<.,_9120");
        System.out.println(loginTest.checkLogin() ? "Успех" : "Неудача");
        loginTest = new Validate("1234", "126@$<.,_9120");
        System.out.println(loginTest.checkLogin() ? "Успех" : "Неудача");
        loginTest = new Validate("mas$ks", "126@$<.,_9120");
        System.out.println(!loginTest.checkLogin() ? "Успех" : "Неудача");
        loginTest = new Validate("ma,sk.s", "126@$<.,_9120");
        System.out.println(!loginTest.checkLogin() ? "Успех" : "Неудача");
        loginTest = new Validate("", "126@$<.,_9120");
        System.out.println(!loginTest.checkLogin() ? "Успех" : "Неудача");

        // проверка пароля
        System.out.println("\nПроверка пароля:");
        Validate passwordTest = new Validate("2312f_fdsf", "126@$<.,_9120");
        System.out.println(passwordTest.checkPassword() ? "Успех" : "Неудача");
        passwordTest = new Validate("1234", "123456789fa");
        System.out.println(!passwordTest.checkPassword() ? "Успех" : "Неудача");
        passwordTest = new Validate("mas$ks", "123456789012");
        System.out.println(passwordTest.checkPassword() ? "Успех" : "Неудача");

        System.out.println("\nПроверка выброса исключений.");
        try {
            validateLogin(new Validate("masks", "123456arg789120"));
        } catch (BadLoginFormatException ex) {
            System.out.println("Неудача: " + ex.getMessage());
        }
        try {
            validatePassword(new Validate("цау", "укпи"));
        } catch (BadPasswordFormatException ex) {
            System.out.println("Неудача: " + ex.getMessage());
        }
    }
}







