import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] commands = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(commands[0])
                .forEach(queue::offer);

        for (int i = 0; i < commands[1]; i++) {
            queue.poll();
        }

        if (queue.contains(commands[2])) {
            System.out.println(true);
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
