import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] numberArray = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int magicSum = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numberArray.length; i++) {
            for (int j = i + 1; j <= numberArray.length - 1; j++) {

                int sum = numberArray[i] + numberArray[j];
                if (sum == magicSum) {
                    System.out.println(numberArray[i] + " " + numberArray[j]);
                }
            }
        }
    }
}
