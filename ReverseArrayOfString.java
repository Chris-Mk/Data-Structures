import java.util.Scanner;

public class ReverseArrayOfString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");

        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }

        System.out.println(String.join(" ", words));
    }
}
