import java.util.Arrays;
import java.util.Scanner;

public class RightRotate {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] elements = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rotations = Integer.parseInt(scan.nextLine());

        System.out.println(Arrays.toString(elements));

        for (int i = 0; i < rotations; i++) {
            int j,lastElement;

            lastElement = elements[elements.length - 1];

            for (j = elements.length - 1; j > 0; j--) {
                elements[j] = elements[j - 1];
            }

            elements[0] = lastElement;
        }

        System.out.println(Arrays.toString(elements));
    }
}
