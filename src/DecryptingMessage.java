import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        String message = "";
        while (n-- > 0) {

            char ch = scan.next().charAt(0);
            message += (char) (ch + key);
        }

        System.out.println(message);
    }
}
