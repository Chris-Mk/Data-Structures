import java.util.Arrays;
import java.util.Scanner;

public class LargestNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((e1, e2) -> Integer.compare(e2, e1))
                .limit(3)
                .forEach(e -> System.out.print(e + " "));
    }
}
