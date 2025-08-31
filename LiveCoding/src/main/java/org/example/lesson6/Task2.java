package org.example.lesson6;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        //  Дано строка. Нужно посчитать сумму всех его цифр.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        String input = scanner.nextLine();

        int sum = sumDigits(input);
        System.out.println("Сумма цифр: " + sum);
    }

    // Метод принимает число в виде строки
    private static int sumDigits(String numStr){
        int sum = 0;

        for(char c : numStr.toCharArray()) {
            if(Character.isDigit(c)){
                sum += Integer.parseInt(String.valueOf(c));
            }
        }
        return sum;
    }
}
