import java.util.Scanner;

public class AdditionOfMatrices {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());
        int[][] matrixA = new int[rows][columns];
        int[][] matrixB = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixA[i][j] = Integer.parseInt(scan.nextLine());
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixB[i][j] = Integer.parseInt(scan.nextLine());
            }
        }

        int[][] matrixSum = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrixSum[row][column] = matrixA[row][column] + matrixB[row][column];
                System.out.print(matrixSum[row][column] + "\t");
            }
            System.out.println();
        }
    }
}
