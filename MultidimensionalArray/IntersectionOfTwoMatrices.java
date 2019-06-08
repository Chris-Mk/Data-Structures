package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int i = 0; i < rows * 2; i++) {
            String[] input = scan.nextLine().split("\\s+");

            for (int j = 0; j < cols; j++) {
                if (i < rows) {
                    firstMatrix[i][j] = input[j].charAt(0);
                } else {
                    secondMatrix[i - rows][j] = input[j].charAt(0);
                }
            }
        }

        char[][] result = new char[rows][cols];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    result[i][j] = '*';
                } else {
                    result[i][j] = firstMatrix[i][j];
                }
            }
        }

        for (char[] chars : result) {
            System.out.println(Arrays.toString(chars).replaceAll("[\\[\\],]", ""));
        }
    }
}
