import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String[] zig = new String[n];
        String[] zag = new String[n];

        for (int i = 0; i < n; i++) {
            String[] integers = scan.nextLine().split(" ");

            if (i % 2 == 0) {
                zig[i] = integers[0];
                zag[i] = integers[1];
            } else {
                zig[i] = integers[1];
                zag[i] = integers[0];
            }
        }

        System.out.println(String.join(" ", zig));
        System.out.println(String.join(" ", zag));
    }
}
