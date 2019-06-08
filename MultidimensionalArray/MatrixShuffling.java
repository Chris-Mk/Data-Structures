package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0], columns = dimensions[1];
        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] input = scan.nextLine().split("\\s+");
            if (columns >= 0) System.arraycopy(input, 0, matrix[i], 0, columns);
        }

        String input;
        while (!"END".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");

            if (data[0].equals("swap") && data.length == 5) {
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows ||
                    col1 < 0 || col1 >= columns || col2 < 0 || col2 >= columns) {
                    System.out.println("Invalid input!");
                } else {
                    String num1 = matrix[row1][col1];
                    String num2 = matrix[row2][col2];
                    matrix[row1][col1] = num2;
                    matrix[row2][col2] = num1;

                    for (String[] row : matrix) {
                        System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
