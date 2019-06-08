package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfAllElementsOfMatrix {
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
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum(matrix));
    }

    private static int sum(int[][] matrix) {
        int sum = 0;

        for (int[] row : matrix) {
            for (int i : row) {
                sum += i;
            }
        }
        return sum;
    }
}
