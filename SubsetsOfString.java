import java.util.Scanner;

public class SubsetsOfString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        
        int numberOfSubsets = (int) Math.pow(2, str.length());
        String[] arr = new String[numberOfSubsets];
        int temp = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                arr[temp++] = str.substring(i, j + 1);
            }
        }

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
