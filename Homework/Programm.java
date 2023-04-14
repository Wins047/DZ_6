package Homework;


import static Homework.Validate.*;

/**
 * Реализовать программу, проверяющую качество логина и пароля по следующим критериям: - логин должен содержать только латинские буквы, цифры, и знак подчеркивания
 * - длина логина не может превышать 20 символов
 * - пароль может содержать те же символы, что и логин, а также любые знаки препинания
 * - минимальная длина пароля – 12 символов
 * - максимальная длина пароля – 20 символов
 * В случае, если был введен неверный пароль, необходимо выбросить исключение BadPasswordFormatException, если неверный логин – BadLoginFormatException.
 * Сообщение об исключении должно быть информативным.
 * Проверку реализовать в виде статического метода, вызываемого из метода main().
 * В main()-методе необходимо обработать данные исключения.
 */


public class Programm {
    public static void main(String[] args) {

        System.out.println("Статическая проверка выполнения кода без выброса и обработки исключения.\n" +
                "Сравнение с заранее известным результатом.\n");
        System.out.println((new Validate("2312f_fdsf", "126@$<.,_9120").checkLogin()) == true);
        System.out.println((new Validate("1234", "126@$<.,_9120").checkLogin()) == true);
        System.out.println((new Validate("mas$ks", "126@$<.,_9120").checkLogin()) == false);
        System.out.println((new Validate("ma,sk.s", "126@$<.,_9120").checkLogin() == false));
        System.out.println((new Validate("", "126@$<.,_9120").checkLogin()) == false);

        System.out.println((new Validate("2312f_fdsf", "126@$<.,_9120").checkPassword()) == true);
        System.out.println((new Validate("1234", "123456789fa").checkPassword()) == false);
        System.out.println((new Validate("mas$ks", "123456789012").checkPassword()) == true);

        System.out.println("\nВыброс исключения.");
        try {
            System.out.println(validateLogin(new Validate("masks", "123456789120")));
            System.out.println(validatePassword(new Validate("2312f_fdsf", "126120")));
        } catch (BadLoginFormatException | BadPasswordFormatException ex) {
            ex.printStackTrace();
        }
    }
}
