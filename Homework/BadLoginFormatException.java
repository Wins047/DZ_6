package Homework;

public class BadLoginFormatException extends Exception {
    public BadLoginFormatException() {
        System.err.println("Некорректный логин. Логин может содержать только латинские буквы, цифры, и знак подчеркивания.\n" +
                " Длина логина должна быть от 1 до 20 символов.");
    }
}