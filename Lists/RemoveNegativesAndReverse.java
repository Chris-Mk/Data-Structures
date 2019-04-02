package Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numberList.removeIf(n -> n < 0);
        Collections.reverse(numberList);

        if (numberList.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(numberList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
