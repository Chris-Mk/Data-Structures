import java.util.Arrays;
import java.util.Scanner;

public class AnagramStrings {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String firstStr = scan.nextLine().toLowerCase();
        String secondStr = scan.nextLine().toLowerCase();

        char[] firstCharStr = firstStr.toCharArray();
        char[] secondCharStr = secondStr.toCharArray();

        Arrays.sort(firstCharStr);
        Arrays.sort(secondCharStr);

        System.out.println(Arrays.equals(firstCharStr, secondCharStr));
    }
}
