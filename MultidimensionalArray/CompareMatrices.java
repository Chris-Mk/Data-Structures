package MultidimensionalArray;

import java.util.Scanner;
import java.util.Arrays;

public class CompareMatrices {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] firstMatrixDimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstRows = firstMatrixDimensions[0];
        int firstColumns = firstMatrixDimensions[1];

        int[][] firstMatrix = new int[firstRows][firstColumns];

        for (int i = 0; i < firstRows; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (firstColumns >= 0) System.arraycopy(input, 0, firstMatrix[i], 0, firstColumns);
        }

        int[] rowsAndColumns = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int secondRows = rowsAndColumns[0];
        int secondColumns = rowsAndColumns[1];
        int[][] secondMatrix = new int[secondRows][secondColumns];

        for (int i = 0; i < secondRows; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (secondColumns >= 0) System.arraycopy(input, 0, secondMatrix[i], 0, secondColumns);
        }

        if (areEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }

            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}