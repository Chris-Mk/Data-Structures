package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (columns >= 0) System.arraycopy(numbers, 0, matrix[i], 0, columns);
        }

        int maxSum = Integer.MIN_VALUE;
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    x1 = matrix[i][j];
                    y1 = matrix[i][j + 1];
                    x2 = matrix[i + 1][j];
                    y2 = matrix[i + 1][j + 1];
                }
            }
        }
        System.out.println(String.format("%d %d", x1, y1));
        System.out.println(String.format("%d %d", x2, y2));
        System.out.println(maxSum);
    }
}
