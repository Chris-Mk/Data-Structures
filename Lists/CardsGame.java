package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Integer> firstHand = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondHand = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < Math.min(firstHand.size(), secondHand.size()); i++) {
            if (firstHand.get(i) > secondHand.get(i)) {
                getCurrentBiggerDigit(secondHand, firstHand, i);
                i = -1;
            } else if (secondHand.get(i) > firstHand.get(i)){
                getCurrentBiggerDigit(firstHand, secondHand, i);
                i = -1;
            } else if (firstHand.get(i).equals(secondHand.get(i))){
                firstHand.remove(firstHand.get(i));
                secondHand.remove(secondHand.get(i));
                i = -1;
            }
        }

        if (firstHand.size() > 0) {
            System.out.printf("First player wins! Sum: %d", firstHand.stream().mapToInt(Integer::intValue).sum());
        } else if (secondHand.size() > 0) {
            System.out.printf("Second player wins! Sum: %d", secondHand.stream().mapToInt(Integer::intValue).sum());
        }
    }

    private static void getCurrentBiggerDigit(List<Integer> firstHand, List<Integer> secondHand, int i) {
        secondHand.add(secondHand.get(i));
        secondHand.add(firstHand.get(i));
        secondHand.remove(secondHand.get(i));
        firstHand.remove(firstHand.get(i));
    }
}
