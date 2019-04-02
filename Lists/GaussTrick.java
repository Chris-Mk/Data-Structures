package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int size = numbersList.size() / 2;

        for (int i = 0; i < size; i++) {
            numbersList.set(i, numbersList.get(i) + numbersList.get(numbersList.size() - 1));
            numbersList.remove(numbersList.size() - 1);
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
