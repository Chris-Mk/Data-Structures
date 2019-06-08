import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] expression = scan.nextLine().split("\\s+");
        Deque<String> stack = new ArrayDeque<>();

        for (int i = expression.length - 1; i >= 0; i--) {
            stack.push(expression[i]);
        }

        while (stack.size() > 1) {
            Integer firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            Integer secondNum = Integer.parseInt(stack.pop());

            if (operator.equals("+")) {
                stack.push(firstNum + secondNum + "");
            } else {
                stack.push(firstNum - secondNum + "");
            }
        }
        System.out.println(stack.peek());
    }
}
