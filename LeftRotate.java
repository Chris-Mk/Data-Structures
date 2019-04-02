import java.util.Arrays;
import java.util.Scanner;

public class LeftRotate {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfRotations = Integer.parseInt(scan.nextLine());

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < numberOfRotations; i++) {
            int j, firstElement;
            firstElement = arr[0];

            for (j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }

            arr[j] = firstElement;
        }

        System.out.println(Arrays.toString(arr));
    }
}
