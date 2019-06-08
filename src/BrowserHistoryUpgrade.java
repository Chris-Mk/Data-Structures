import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Deque<String> back = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();

        String line;
        while (!"Home".equals(line = scan.nextLine())) {
            if ("back".equals(line)) {
                if (back.size() > 1) {
                    forward.offerLast(back.pollLast());
                    System.out.println(back.peekLast());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if ("forward".equals(line)){
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forward.peekLast());
                    back.offerLast(forward.pollLast());
                }
            } else {
                back.offerLast(line);
                System.out.println(back.peekLast());

                if (!forward.isEmpty()) {
                    forward.clear();
                }
            }
        }
    }
}
