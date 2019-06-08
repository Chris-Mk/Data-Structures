import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int ch = 1; ch <= n; ch++) {
            int sum = 0;
            int digits = ch;

            while (digits > 0) {
                sum += digits % 10;
                digits = digits / 10;
            }
            boolean isSpecialNum = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecialNum) {
                System.out.printf("%d -> True%n", ch);
            } else {
                System.out.printf("%d -> False%n", ch);
            }
        }
    }
}
