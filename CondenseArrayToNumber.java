import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] numberArrays = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;

        while (numberArrays.length > 1) {
            int[] condensed = new int[numberArrays.length - 1];

            for (int j = 0; j < condensed.length; j++) {
                condensed[j] = numberArrays[j] + numberArrays[j + 1];
            }

            numberArrays = condensed;
        }

        System.out.println(numberArrays[0]);
    }
}
