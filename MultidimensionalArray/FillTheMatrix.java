package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char patternType = input[1].charAt(0);

        if (patternType == 'A') {
            printPatternA(n);
        } else if (patternType == 'B') {
            printPatternB(n);
        }
    }

    private static void printPatternA(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = count++;
            }
        }

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    private static void printPatternB(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    matrix[j][i] = count++;
                } else {
                    matrix[n - 1 - j][i] = count++;
                }
            }
        }

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }
}
