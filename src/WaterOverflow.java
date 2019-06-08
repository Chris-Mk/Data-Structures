import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int litersIn = Integer.parseInt(scan.nextLine());
            sum += litersIn;

            if (sum > 255) {
                System.out.println("Insufficient capacity!");
                sum -= litersIn;
            }
        }

        System.out.println(sum);
    }
}
