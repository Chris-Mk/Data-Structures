import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double floatNumber1 = Double.parseDouble(scan.nextLine());
        double floatNumber2 = Double.parseDouble(scan.nextLine());

        if (Math.abs(floatNumber1 - floatNumber2) > 0.000001) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
