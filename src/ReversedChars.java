import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char ch1 = scan.next().charAt(0);
        char ch2 = scan.next().charAt(0);
        char ch3 = scan.next().charAt(0);

        System.out.printf("%c %c %c", ch3, ch2, ch1);
    }
}
