import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            if (input.length() > 1) {
                String[] commands = input.split("\\s+");
                stack.push(Integer.parseInt(commands[1]));
            } else {
                switch (input) {
                    case "2":
                        stack.pop();
                        break;
                    case "3":
                        System.out.println(Collections.max(stack));
                        break;
                }
            }
        }
    }
}
