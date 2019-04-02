import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] arr1 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] arr2 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0, index = -1;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                index = i;
                break;
            }
            sum += arr1[i];
        }

        if (index == -1) {
            System.out.println("Arrays are identical. Sum: " + sum);
        } else {
            System.out.println("Arrays are not identical. Found difference at " + index + " index.");
        }
    }
}
