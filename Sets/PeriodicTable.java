package Sets;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] compound = scan.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(compound));
        }
        elements.forEach(e -> System.out.print(e + " "));
    }
}
