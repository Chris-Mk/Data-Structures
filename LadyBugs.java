import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int fieldSize = Integer.parseInt(scan.nextLine());
        String[] initialIndexes = scan.nextLine().split(" ");
        int[] fieldIndexes = new int[fieldSize];

        for (int i = 0; i < initialIndexes.length; i++) {
            int index = Integer.parseInt(initialIndexes[i]);

            if (index >= 0 && index < fieldSize) {
                fieldIndexes[index] = 1;
            }
        }

        String command;
        while (!"end".equals(command = scan.nextLine())) {
            String[] data = Arrays.stream(command.split(" "))
                    .filter(e -> !e.equals(""))
                    .toArray(String[]::new);

            int startIndex = Integer.parseInt(data[0]);
            String action = data[1];
            int flyLength = Integer.parseInt(data[2]);

            if (startIndex < 0 || startIndex > fieldSize - 1 || fieldIndexes[startIndex] == 0) {
                continue;
            }

            fieldIndexes[startIndex] = 0;
            if (action.equals("right")) {
                startIndex += flyLength;

                while (startIndex < fieldSize && fieldIndexes[startIndex] == 1) {
                    startIndex += flyLength;

                }

                if (startIndex < fieldSize) {
                    fieldIndexes[startIndex] = 1;
                }
            } else {
                startIndex -= flyLength;

                while (startIndex >= 0 && fieldIndexes[startIndex] == 1) {
                    startIndex -= flyLength;
                }

                if (startIndex >= 0) {
                    fieldIndexes[startIndex] = 1;
                }
            }
        }

        for (int i = 0; i < fieldSize; i++) {
            System.out.print(fieldIndexes[i] + " ");
        }
    }
}
