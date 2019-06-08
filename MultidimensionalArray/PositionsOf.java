package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.arraycopy(numbers, 0, matrix[i], 0, columns);
        }

        int numberToCheck = Integer.parseInt(scan.nextLine());
        coordinates(matrix, numberToCheck);
    }

    private static void coordinates(int[][] matrix, int number) {
        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    System.out.println(String.format("%d %d", i, j));
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}
