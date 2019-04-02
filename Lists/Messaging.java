package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String text = scan.nextLine();

        for (int i = 0; i < numbers.size(); i++) {
            int element = numbers.get(i);

            int sum = 0;
            while (element > 0) {
                sum += element % 10;
                element /= 10;
            }


        }
    }
}
