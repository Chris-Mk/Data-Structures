import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] expression = scan.nextLine().split("\\s");
        ArrayDeque<Character> output = new ArrayDeque<>();
        ArrayDeque<Character> operator = new ArrayDeque<>();
        int operatorIndex = -1;

        for (int i = 0; i < expression.length; i++) {
            char token = expression[i].charAt(0);

            if (Character.isDigit(token)) {
                output.push(token);
            } else if (token == '+' || token == '-'
                    || token == '*' || token == '/') {

                if (operator.isEmpty()) {
                    operator.push(token);
                    operatorIndex = i;
                } else {
                }
            }
        }
    }
}
