import java.util.Scanner;

public class LongestRepeatingSequence {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        char[] chars = str.toCharArray();
        int longestSequence = 0;
        String character = "";

        for (int i = 0; i < chars.length; i++) {
            int count = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                }
            }

            if (count > longestSequence) {
                longestSequence = count;
                character = String.valueOf(chars[i]);
            }
        }

        System.out.println(character);
        System.out.println(longestSequence);
    }
}
