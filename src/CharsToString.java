import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char ch1 = scan.next().charAt(0);
        char ch2 = scan.next().charAt(0);
        char ch3 = scan.next().charAt(0);

        System.out.println("" + ch1 + ch2 + ch3);
    }
}
