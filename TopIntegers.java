import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] numberArray = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numberArray.length; i++) {
            boolean isGreater = true;

            for (int j = i + 1; j < numberArray.length; j++) {
                if (numberArray[i] <= numberArray[j]) {
                    isGreater = false;
                    break;
                }
            }

            if (isGreater) {
                System.out.print(numberArray[i] + " ");
            }
        }
    }
}