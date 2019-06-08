package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char firstChar = (char) ('a' + i);
                char middleChar = (char) ('a' + i + j);
                char lastChar = (char) ('a' + i);
                matrix[i][j] = "" + firstChar + middleChar + lastChar;
            }
        }

        for (String[] strings : matrix) {
            System.out.println(Arrays.toString(strings).replaceAll("[\\[\\],]", ""));
        }
    }
}