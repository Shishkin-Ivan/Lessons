package org.example.lesson5;

//    Задача: На вход приходит номер телефона который начинается с +.
//    Необходимо маскировать цифры в номере, чтобы номер принял следующий вид: +NN**..**NN.
//    Количество звездочек должно соответствовать количеству замаскированных символов.
public class MaskNumber {

    public static void main(String[] args) {
        System.out.println(maskPhone("+79113456673"));
    }

    public static String maskPhone(final String phone) {
        return phone.replaceAll("(?<=...).(?=..)", "*");
    }
}