import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        if (n <= 0) {
            System.out.println(0);
            return;
        }

        long[] fibonacciSeries = new long[n + 1];
        fibonacciSeries[0] = 1;
        fibonacciSeries[1] = 1;

        for (int i = 2; i < fibonacciSeries.length; i++) {
            fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];

        }

        System.out.println(fibonacciSeries[n]);
    }
}
