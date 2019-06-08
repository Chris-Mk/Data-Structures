package MultidimensionalArray;

import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = scan.nextLine().split("\\s+");
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row >= 0) {
            int r = row;
            int c = col;

            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;

            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }
}
