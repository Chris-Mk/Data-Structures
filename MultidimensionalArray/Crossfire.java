package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Crossfire {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0], columns = dimensions[1];
        int[][] matrix = new int[rows][columns];

        int elements = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = elements++;
            }
        }

        String input;
        while (!"Nuke it from orbit".equals(input = scan.nextLine())) {
            int[] indices = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = indices[0];
            int col = indices[1];
            int radius = indices[2];

            // mark values for detonation in column
            for (int i = row - radius; i <= row + radius ; i++) {
                if(isInsideTheMatrix(i, col, matrix)) {
                    matrix[i][col] = 0;
                }
            }

            // mark values for detonation in row
            for (int i = col - radius; i <= col + radius ; i++) {
                if(isInsideTheMatrix(row, i, matrix)) {
                    matrix[row][i] = 0;
                }
            }

            // update columns
            boolean foundEmptyRows = false;
            for (int r = 0; r < matrix.length; r++) {
                if (IntStream.of(matrix[r]).anyMatch(e -> e == 0)) {
                    matrix[r] = Arrays.stream(matrix[r])
                            .filter(value -> value > 0)
                            .toArray();

                    if(matrix[r].length == 0) foundEmptyRows = true;
                }
            }

            // delete empty rows
            if (foundEmptyRows) {
                matrix = Arrays.stream(matrix)
                        .filter(e -> e.length > 0)
                        .toArray(int[][]::new);
            }
        }
        printMatrix(matrix);
    }

    private static boolean isInsideTheMatrix(int row, int col, int[][] matrix) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length;
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
                .filter(e -> e.length > 0)
                .forEach(e -> System.out.println(Arrays.toString(e).replaceAll("[\\[\\],]", "")));
    }
}
