package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0], columns = dimensions[1];
        char[][] lair = new char[rows][columns];
        int xPos = -1, yPos = -1;

        for (int i = 0; i < rows; i++) {
            String[] input = scan.nextLine().split("");

            for (int j = 0; j < columns; j++) {
                lair[i][j] = input[j].charAt(0);

                if (lair[i][j] == 'P') {
                    xPos = i;
                    yPos = j;
                    lair[i][j] = '.';
                }
            }
        }

        String directions = scan.nextLine();
        boolean hasWon = false;

        int i = 0;
        do {
            if (directions.charAt(i) == 'U') {
                if (xPos > 0) {
                    xPos--;
                } else {
                    hasWon = true;
                }
            } else if (directions.charAt(i) == 'D') {
                if (xPos < rows - 1) {
                    xPos++;
                } else {
                    hasWon = true;
                }
            } else if (directions.charAt(i) == 'L') {
                if (yPos > 0) {
                    yPos--;
                } else {
                    hasWon = true;
                }
            } else if (directions.charAt(i) == 'R') {
                if (yPos < columns - 1) {
                    yPos++;
                } else {
                    hasWon = true;
                }
            }

            int[][] bunniesPositions = newBunniesPositions(lair);
            for (int j = 0; j < bunniesPositions.length; j++) {
                for (int k = 0; k < bunniesPositions[j].length; k++) {
                    if (bunniesPositions[j][k] == 1) {
                        int left = k - 1, right = k + 1,
                            up = j - 1, down = j + 1;

                        //check going down
                        if (down < lair.length) {
                            lair[down][k] = 'B';
                        }

                        //check going right
                        if (right < lair[j].length) {
                            lair[j][right] = 'B';
                        }

                        //check going up
                        if (up >= 0) {
                            lair[up][k] = 'B';
                        }

                        //check going left
                        if (left >= 0) {
                            lair[j][left] = 'B';
                        }
                    }
                }
            }

            if (lair[xPos][yPos] == 'B' || hasWon) {
                break;
            }
            i++;
        } while (i < directions.length());

        for (char[] row : lair) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\], ]", ""));
        }

        if (hasWon) {
            System.out.println(String.format("won: %d %d", xPos, yPos));
        } else {
            System.out.println(String.format("dead: %d %d", xPos, yPos));
        }
    }

    private static int[][] newBunniesPositions(char[][] lair) {
        int[][] bunnies = new int[lair.length][lair[0].length];

        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                if (lair[i][j] == 'B') {
                    bunnies[i][j] = 1;
                } else {
                    bunnies[i][j] = 0;
                }
            }
        }
        return bunnies;
    }
}