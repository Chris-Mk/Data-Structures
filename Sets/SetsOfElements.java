package Sets;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int firstLength = scan.nextInt();
        int secondLength = scan.nextInt();
        scan.nextLine();

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstLength + secondLength; i++) {
            String number = scan.nextLine();

            if (i < firstLength) {
                firstSet.add(number);
            } else {
                secondSet.add(number);
            }
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
