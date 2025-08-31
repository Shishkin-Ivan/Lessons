package org.example.lesson3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


// Вывести те элементы из списка,
// которые больше среднего значения
public class Task2 {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 3, 6, 9, 11, 42, 27);

        System.out.println(greaterThenAvg(list));

    }

    private static List<Integer> greaterThenAvg(List<Integer> list) {
        double avg = list.stream().mapToInt(i -> i).average().orElseThrow();
        return list.stream().filter(e -> e > avg).collect(Collectors.toList());
    }
}
