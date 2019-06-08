package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        char[][] characters = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            String[] chars = scan.nextLine().split("\\s+");

            for (int c = 0; c < cols; c++) {
                characters[r][c] = chars[c].charAt(0);
            }
        }

        char fillChar = scan.nextLine().charAt(0);
        int startRow = scan.nextInt();
        int startCol = scan.nextInt();
        scan.nextLine();
        char startChar = characters[startRow][startCol];

        fillCell(startRow, startCol, startChar, fillChar, characters);
        Arrays.stream(characters)
                .forEach(e -> System.out.println(Arrays.toString(e).replaceAll("[\\[\\], ]", "")));
    }

    private static void fillCell(int startRow, int startCol, char startChar, char fillChar, char[][] characters) {
        if (startRow < 0 || startCol < 0 || startRow == characters.length || startCol == characters[startRow].length || characters[startRow][startCol] != startChar) {
            return;
        }
        characters[startRow][startCol] = fillChar;
        // up
        fillCell(startRow - 1, startCol, startChar, fillChar, characters);
        // down
        fillCell(startRow + 1, startCol, startChar, fillChar, characters);
        // left
        fillCell(startRow, startCol - 1, startChar, fillChar, characters);
        // right
        fillCell(startRow, startCol + 1, startChar, fillChar, characters);
    }
}
