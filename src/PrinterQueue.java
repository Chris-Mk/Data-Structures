import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Deque<String> queue = new ArrayDeque<>();
        String file;

        while (!"print".equals(file = scan.nextLine())) {
            if (!"cancel".equals(file)) {
                queue.offer(file);
            } else {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.pollFirst());
                }
            }
        }
        queue.forEach(System.out::println);
    }
}
