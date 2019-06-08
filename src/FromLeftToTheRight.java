import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            long first = Long.parseLong(scanner.next());
            long second = Long.parseLong(scanner.next());

            int sum = 0;
            if (first > second) {
                String toString = Long.toString(first);

                for (int j = 0; j < toString.length(); j++) {
                    long lastDigit = first % 10;
                    sum += lastDigit;
                    first /= 10;
                }
            } else {
                String toString = Long.toString(second);

                for (int j = 0; j < toString.length(); j++) {
                    long lastDigit = second % 10;
                    sum += lastDigit;
                    second /= 10;
                }
            }

            System.out.println(Math.abs(sum));
        }
    }
}