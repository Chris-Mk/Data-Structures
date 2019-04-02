import java.util.Arrays;
import java.util.Scanner;

public class ElementsFrequency {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] elements = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] frequencies = new int[elements.length];
        int visited = -1;

        for (int i = 0; i < elements.length; i++) {
            int count = 1;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[i] == elements[j]) {
                    count++;
                    frequencies[j] = visited;
                }
            }

            if (frequencies[i] != visited) {
                frequencies[i] = count;
            }
        }

        System.out.println("Element | Frequency");
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] != visited) {
                System.out.printf("\t%d \t|\t %d\n", elements[i], frequencies[i]);
            }
        }
    }
}
