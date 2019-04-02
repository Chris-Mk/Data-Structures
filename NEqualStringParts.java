import java.util.Scanner;

public class NEqualStringParts {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());

        int chars = str.length() / n;
        int index = 0;
        String[] equalStr = new String[n];

        if (str.length() % n == 0) {
            for (int i = 0; i < str.length(); i = i + chars) {
                String part = str.substring(i , i + chars);
                equalStr[index++] = part;
            }

            System.out.println(n + " equal parts of given string are ");
            for (String s : equalStr) {
                System.out.println(s);
            }
        } else {
            System.out.println("Sorry this string cannot be divided into " + n + " equal parts.");
        }
    }
}
