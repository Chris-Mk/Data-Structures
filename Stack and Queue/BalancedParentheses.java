import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String brackets = scan.nextLine();
        Stack<Character> balanced = new Stack<>();
        boolean isBalanced = true;

        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(' || brackets.charAt(i) == '[' || brackets.charAt(i) == '{') {
                balanced.push(brackets.charAt(i));
            } else {
                if (balanced.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                if ((brackets.charAt(i) == ')' && balanced.peek() == '(') ||
                        (brackets.charAt(i) == ']' && balanced.peek() == '[') ||
                        (brackets.charAt(i) == '}' && balanced.peek() == '{')) {
                    balanced.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
