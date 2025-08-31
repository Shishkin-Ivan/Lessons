package org.example.lesson3;

import java.util.List;

/**
 * Реализовать код метода с помощью StreamAPI. Метод должен вернуть сумму всех элементов в списке.
 */
public class Task {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 3, 6, 9, 11, 42, 27);
        int result = sum(list);

        System.out.println(result == 99);

        System.out.println(sum(list));
    }

    private static int sum(List<Integer> list) {
        return list.stream().filter((a) -> a % 3 == 0).reduce(0, (a, b) -> ++a);

    }
}