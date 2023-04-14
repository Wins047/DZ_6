package Homework;

public interface CheckValidation {
    default boolean checkLogin() {
        return true;
    }
    default boolean checkPassword() {
        return true;
    }
}