package WorkShop;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        mergeSort(array);
        System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length / 2;
        int secondPartitionLength = array.length - midIndex;

        int[] firstPartition = new int[midIndex];
        int[] secondPartition = new int[secondPartitionLength];

        for (int i = 0; i < midIndex; i++) {
            firstPartition[i] = array[i];
        }

        for (int i = midIndex; i < array.length; i++) {
            secondPartition[i - midIndex] = array[i];
        }

        mergeSort(firstPartition);
        mergeSort(secondPartition);

        int mainIndex = 0;
        int firstPartitionIndex= 0;
        int secondPartitionIndex= 0;

        while (firstPartitionIndex < midIndex && secondPartitionIndex < secondPartitionLength) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex++] = firstPartition[firstPartitionIndex++];
            } else {
                array[mainIndex++] = secondPartition[secondPartitionIndex++];
            }
        }

        while (firstPartitionIndex < midIndex) {
            array[mainIndex++] = firstPartition[firstPartitionIndex++];
        }

        while (secondPartitionIndex < secondPartitionLength) {
            array[mainIndex++] = secondPartition[secondPartitionIndex++];
        }
        return array;
    }
}
