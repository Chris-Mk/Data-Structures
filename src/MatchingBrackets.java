import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String expresion = scan.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '(')  {
                stack.push(i);
            } else if (expresion.charAt(i) == ')') {
                System.out.println(expresion.substring(stack.pop(), i + 1));
            }
        }
    }
}
