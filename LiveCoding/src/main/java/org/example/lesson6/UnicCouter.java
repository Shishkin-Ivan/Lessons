package org.example.lesson6;

public class UnicCouter {
    public static void main(String[] args) {
//        Дан массив целых чисел. Нужно посчитать, сколько в нём уникальных (неповторяющихся) чисел.
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println("Unique count: " + countUnique(nums));
    }

    private static int countUnique(int[] nums) {
        int count = nums.length;

        int innerCounter = 0;

        for(int i=0; i < nums.length; i++){
            int value = nums[i];
            for(int j=0; j < nums.length; j++){
                if(i != j && value == nums[j]){
                    innerCounter++;
                }
            }
        }
        return count - innerCounter;
    }
}
