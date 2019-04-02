package Sorting;

import java.util.Arrays;

public class SelectingSorting {
    public static void main(String[] args) {

        int[] arr1 = {9, 14, 3, 2, 43, 11, 58, 22};
        //int[] arr2 = new int[arr1.length];

        System.out.println("Array before selection sorting:");
        System.out.println(Arrays.toString(arr1));

        for (int i = 0; i < arr1.length; i++) {
            int index = 0;
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[j] < arr1[index]) {
                    index = j;
                }
            }
            int smallNum = arr1[index];
            arr1[index] = arr1[i];
            arr1[i] = smallNum;
        }

        System.out.println("Array after selection sorting:");
        System.out.println(Arrays.toString(arr1));
    }
}
