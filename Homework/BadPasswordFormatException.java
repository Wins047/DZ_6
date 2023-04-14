package Homework;

public class BadPasswordFormatException extends Exception {
    public BadPasswordFormatException() {
        System.err.println("Некорректный пароль. Пароль должен содержать только латинские буквы, цифры, знак подчеркивания\n" +
                " и любые знаки препинания. Длина пароля должна быть от 12 до 20 символов.");
    }
}