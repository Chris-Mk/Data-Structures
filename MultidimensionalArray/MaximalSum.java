package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = dimensions[0], m = dimensions[1];
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (m >= 0) System.arraycopy(input, 0, matrix[i], 0, m);
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[3][3];

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    subMatrix[0][0] = matrix[i][j];
                    subMatrix[0][1] = matrix[i][j + 1];
                    subMatrix[0][2] = matrix[i][j + 2];
                    subMatrix[1][0] = matrix[i + 1][j];
                    subMatrix[1][1] = matrix[i + 1][j + 1];
                    subMatrix[1][2] = matrix[i + 1][j + 2];
                    subMatrix[2][0] = matrix[i + 2][j];
                    subMatrix[2][1] = matrix[i + 2][j + 1];
                    subMatrix[2][2] = matrix[i + 2][j + 2];
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int[] row : subMatrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }
}
