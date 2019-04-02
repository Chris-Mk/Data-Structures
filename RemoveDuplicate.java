import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] elements = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = new int[elements.length];
        Arrays.sort(elements);

        for (int i = 0; i < elements.length - 1; i++) {
            if (elements[i] != elements[i + 1]) {
                result[i] = elements[i];
            }
        }

        result[elements.length - 1] = elements[elements.length - 1];

        for (int i : result) {
            if (i != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
