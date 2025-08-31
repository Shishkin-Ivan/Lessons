package org.example.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task3 {

    /**
     * Отсортировать массив целых чисел по убыванию частоты элементов.
     * При одинаковой частоте сортирует по возрастанию значения.
     *
     */
    public static void main(String[] args) {
        int[] array = {2, -1, 5, 2, 6, -1, 99, 5, 8, 8, 8};
        int[] sortedArray = sortByFrequency(array);

        System.out.println(Arrays.toString(sortedArray)); // Вывод: [8, 2, 5, 6, -1, 99]
    }

    public static int[] sortByFrequency(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            int result = o2.getValue().compareTo(o1.getValue());
            if (result == 0) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return result;
            }
        });
        Set<Integer> set = new LinkedHashSet<>();

        for(Map.Entry<Integer, Integer> entry : list) {
            set.add(entry.getKey());
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

}
