import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] children = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        Deque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, children);

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
