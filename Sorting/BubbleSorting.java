package Sorting;

import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {

        int[] numbers = {3, 60, 35, 2, 45, 320, 5};
        int temp;

        System.out.println("Array before bubble sorting:");
        System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                if (numbers[j - 1] > numbers[j]) {
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("Array after bubble sorting:");
        System.out.println(Arrays.toString(numbers));
        /*for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }*/
    }
}
