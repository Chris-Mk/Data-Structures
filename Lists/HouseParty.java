package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> names = new ArrayList<>();

        while (n-- > 0){
            String[] input = scan.nextLine().split("\\s+");

            if (input[2].equals("not")) {
                if (!names.contains(input[0])) {
                    System.out.printf("%s is not in the list!\n", input[0]);
                }
                names.remove(input[0]);
            } else {
                if (names.contains(input[0])) {
                    System.out.printf("%s is already in the list!\n", input[0]);
                } else {
                    names.add(input[0]);
                }
            }
        }

        System.out.println(String.join("\n", names));
    }
}
