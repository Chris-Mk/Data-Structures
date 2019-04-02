import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] sums = new int[n];

        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            char[] ch = str.toCharArray();
            int vowel = 0, consonant = 0;

            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == 'a' || ch[j] == 'e'
                        || ch[j] == 'i' || ch[j] == 'o'
                        || ch[j] == 'u' || ch[j] == 'A'
                        || ch[j] == 'E' || ch[j] == 'I'
                        || ch[j] == 'O' || ch[j] == 'U') {
                    vowel += str.length() * ch[j];
                } else {
                    consonant += ch[j] / str.length();
                }
            }

            sums[i] = vowel + consonant;
        }

        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                if (sums[i] > sums[j]) {
                    int temp = sums[i];
                    sums[i] = sums[j];
                    sums[j] = temp;
                }
            }
        }

        for (int sum : sums) {
            System.out.println(sum);
        }
    }
}
