import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] numberArray = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numberArray.length; i++) {

            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += numberArray[j];
            }

            int rightSum = 0;
            for (int j = i + 1; j < numberArray.length; j++) {
                rightSum += numberArray[j];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("no");
    }
}
