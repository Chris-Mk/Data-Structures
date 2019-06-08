package MultidimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0], columns = dimensions[1];
        int[][] parkingLot = new int[rows][columns];

        String input;
        while (!"stop".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");
            int entry = Integer.parseInt(data[0]);
            int row = Integer.parseInt(data[1]);
            int col = Integer.parseInt(data[2]);

            if ((col < 1 || col >= columns) || (row < 0 || row >= rows)) {
                continue;
            }

            int min = Math.min(entry, row);
            int max = Math.max(entry, row);
            int steps = 1;

            for (int i = min; i < max; i++) {
                steps++;
            }

            if (parkingLot[row][col] != 1) {
                parkingLot[row][col] = 1;
                steps += col;
            } else {
                int i;
                for (i = col - 1; i >= 1; i--) {
                    if (parkingLot[row][i] != 1) {
                        parkingLot[row][i] = 1;
                        break;
                    }
                }
                steps += i;

                if (i == 0) {
                    int j;
                    for (j = col + 1; j < parkingLot[row].length; j++) {
                        if (parkingLot[row][j] != 1) {
                            parkingLot[row][j] = 1;
                            break;
                        }
                    }
                    steps += j;

                    if (j == parkingLot[row].length) {
                        System.out.println(String.format("Row %d full", row));
                        continue;
                    }
                }
            }
            System.out.println(steps);
        }
    }
}
