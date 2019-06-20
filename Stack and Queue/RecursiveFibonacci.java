import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] memory;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        memory = new long[n + 1];

        System.out.println(getFibonacci(n));
    }

    private static long getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }
        return memory[n] = getFibonacci(n - 2) + getFibonacci(n - 1);
    }
}
