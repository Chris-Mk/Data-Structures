import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int[] start = {1};
        System.out.println(1);

        for (int i = 0; i < n - 1 ; i++) {
            int[] end = new int[start.length + 1];

            for (int j = 0; j < end.length; j++) {
                if (j == 0 || j == end.length - 1) {
                    end[j] = 1;
                } else {
                    end[j] = start[j - i] + start[j - 1];
                }
            }
        }
    }
}
