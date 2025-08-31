package org.example;

import java.util.Arrays;

/**
 * Написать метод, который принимает несортированный массив целых чисел и возвращает true,
 * <p>
 * если все элементы массива можно упорядочить так, чтобы они образовали арифметическую прогрессию.
 * <p>
 * Арифметическая прогрессия — последовательность, где разность между соседними элементами постоянна:
 * <p>
 * arr[i + 1] - arr[i] == arr[1] - arr[0]
 * <p>
 * Примеры:
 * <p>
 * Input: {5, 1, 3, 4, 2}, true
 * <p>
 * Input: {7, 3, 5, 1}, true
 * <p>
 * Input: {1, 2, 4, 6}, false
 */
public class ArithmeticProgression {

    public static void main(String[] args) {
        int[] firstArray = {5, 1, 3, 4, 2};
        int[] secondArray = {7, 3, 5, 1};
        int[] thirdArray = {1, 2, 4, 6};
        int[] fourthArray = {2, 4, 6, 7};

        System.out.println(canFormArithmeticProgression(firstArray));
        System.out.println(canFormArithmeticProgression(secondArray));
        System.out.println(canFormArithmeticProgression(thirdArray));
        System.out.println(canFormArithmeticProgression(fourthArray));
    }

    public static boolean canFormArithmeticProgression(int[] array) {
        if (array == null || array.length == 0 || array.length == 1){
            throw new RuntimeException("Invalid array length");
        }

        Arrays.sort(array);
        int diff = array[1] - array[0];

        for(int i = 2; i < array.length; i++) {
            if(array[i]-array[i-1] != diff) {
                return false;
            }
        }
        return true;
    }
}
