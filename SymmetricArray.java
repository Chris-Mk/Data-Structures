import java.util.Scanner;

public class SymmetricArray {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        boolean isSymmetric = true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[n - i - 1]) {
                isSymmetric = false;
            }
        }
        System.out.printf("Symmetric? %b%n", isSymmetric);
    }
}
