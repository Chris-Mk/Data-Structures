import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxCount = 0;
        int maxIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currentCount = 0;

            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    currentCount++;

                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                        maxIndex = i;
                    }
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(numbers[i + maxIndex] + " ");
        }
    }
}
