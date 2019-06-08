package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = input;
        }

        int[] mistakes = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = mistakes[0], col = mistakes[1];
        int numToReplace = matrix[row][col];
        int[][] result = new int[rows][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == numToReplace) {
                    int left = j - 1, right = j + 1,
                          up = i - 1, down = i + 1;

                    int sum = 0;
                    if (up >= 0 && matrix[up][j] != numToReplace) sum += matrix[up][j];
                    if (down < matrix.length && matrix[down][j] != numToReplace) sum += matrix[down][j];
                    if (left >= 0 && matrix[i][left] != numToReplace) sum += matrix[i][left];
                    if (right < matrix[i].length && matrix[i][right] != numToReplace) sum += matrix[i][right];
                    result[i][j] = sum;
                } else {
                    result[i][j] = matrix[i][j];
                }
            }
        }

        for (int[] line : result) {
            System.out.println(Arrays.toString(line).replaceAll("[\\[\\],]", ""));
        }
    }
}
