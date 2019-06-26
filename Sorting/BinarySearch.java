package WorkShop;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int key = Integer.parseInt(scan.nextLine());

        System.out.println(binarySearch(array, key));
    }

    private static int binarySearch(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid] < key) {
                start = mid + 1;
            } else if (array[mid] > key) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
