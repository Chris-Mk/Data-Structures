import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> sites = new ArrayDeque<>();

        String line;
        while (!"Home".equals(line = scan.nextLine())) {
            if (!"back".equals(line)) {
                sites.push(line);
                System.out.println(sites.peek());
            } else {
                if (sites.size() > 1) {
                    sites.pop();
                    System.out.println(sites.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }
        }
    }
}
