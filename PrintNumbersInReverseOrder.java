import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] originalOrder = new int[n];

        for (int i = 0; i < n; i++) {
            originalOrder[i] =Integer.parseInt(scan.nextLine());
        }

        for (int i = n; i > 0; i--) {
            System.out.print(originalOrder[i - 1] + " ");
        }
    }
}
