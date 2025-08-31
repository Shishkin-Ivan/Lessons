package org.example;

import java.util.Arrays;

/**
 * Дан массив с целыми числами.
 * <p>
 * Нужно реализовать метод, который инвертирует массив —
 * <p>
 * элементы должны идти в обратном порядке.
 * <p>
 * Пример:
 * <p>
 * Вход: {1, 2, 3, 4, 5}
 * <p>
 * Выход: {5, 4, 3, 2, 1}
 */

public class InvertArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};

        invertArray(array);

        System.out.println(Arrays.toString(array));
    }

    public static void invertArray(int[] array) {
        int length = array.length;

        for(int i=0; i<length/2; i++){
            int startValue = array[i];
            int endValue = array[length-i-1];

            array[i] = endValue;
            array[length-i-1] = startValue;
        }
        //return array;
    }
}