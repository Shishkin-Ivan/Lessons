package org.example.lesson4;

import java.util.Arrays;
import java.util.stream.IntStream;

//Найти простые числа
public class PrimeNumberFinder {

    public static void main(final String[] args) {
        System.out.println(Arrays.toString(getPrimeNumbers(100)));
    }

    public static int[] getPrimeNumbers(final int quantity) {
        return IntStream.iterate(2, n -> n + 1) // Генерация последовательности чисел, начиная с 2
                .filter(PrimeNumberFinder::isPrime) // Фильтрация простых чисел
                .limit(quantity) // Ограничиваем количество до нужного
                .toArray();
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false; // 1 и отрицательные числа не простые
        return IntStream.rangeClosed(2, (int) Math.sqrt(num)) // Генерация диапазона от 2 до корня числа
                .noneMatch(i -> num % i == 0); // Проверяем, есть ли делители
    }
}
