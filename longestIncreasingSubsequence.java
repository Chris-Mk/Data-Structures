import java.util.Arrays;
import java.util.Scanner;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] numberList = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] increasingSequence = new int[numberList.length];
        boolean isGreater = true;

        for (int i = 0; i < numberList.length; i++) {
            for (int j = i + 1; j < numberList.length; j++) {

                if (numberList[i] > numberList[j]) {
                    isGreater = false;
                }
            }

            if (isGreater) {
                increasingSequence[i] = numberList[i];
            }
        }

        for (int i1 : increasingSequence) {
            System.out.printf("%d ", i1);
        }
    }
}
