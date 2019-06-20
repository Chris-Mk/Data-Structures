import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] checkers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = checkers[0];
        int s = checkers[1];
        int x = checkers[2];

        ArrayDeque<Integer> processed = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(n)
                .forEach(processed::push);

        for (int i = 0; i < s; i++) {
            processed.pop();
        }

        if (processed.contains(x)) {
            System.out.println(true);
        } else {
            if (processed.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(processed));
            }
        }
    }
}
