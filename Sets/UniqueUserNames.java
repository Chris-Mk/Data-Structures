package Sets;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUserNames {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> userNames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String user = scan.nextLine();
            userNames.add(user);
        }
        userNames.forEach(System.out::println);
    }
}
