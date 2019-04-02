import java.util.Arrays;
import java.util.Scanner;

public class DuplicateElements {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] elements = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[i] == elements[j]) {
                    System.out.print(elements[i] + " ");
                }
            }
        }
    }
}
