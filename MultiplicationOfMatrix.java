import java.util.Scanner;

public class MultiplicationOfMatrix {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixA[i][j] = Integer.parseInt(scan.nextLine());
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = Integer.parseInt(scan.nextLine());
            }
        }

        int[][] matrixC = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrixC[row][col] = 0;
                for (int i = 0; i < rows; i++) {
                    matrixC[row][col] += matrixA[row][i] * matrixB[i][col];
                }
                System.out.print(matrixC[row][col] + " ");
            }
            System.out.println();
        }
    }
}
