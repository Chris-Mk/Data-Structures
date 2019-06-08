package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = numbers;
        }

        int[] firstDiagonal = new int[n];
        int[] secondDiagonal = new int[n];

        for (int i = 0; i < n; i++) {
            firstDiagonal[i] = matrix[i][i];
            secondDiagonal[i] = matrix[n - 1 - i][i];
        }

        System.out.println(Arrays.toString(firstDiagonal).replaceAll("[\\[\\],]", ""));
        System.out.println(Arrays.toString(secondDiagonal).replaceAll("[\\[\\],]", ""));
    }
}
