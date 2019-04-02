package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Integer> time = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        double leftRacer = 0, rightRacer = 0;

        for (int i = 0; i < time.size() / 2; i++) {
            if (time.get(i) == 0) {
                leftRacer *= .80;
            }

            if (time.get(time.size() - 1 - i) == 0) {
                rightRacer *= .80;
            }

            leftRacer += time.get(i);
            rightRacer += time.get(time.size() - 1 - i);
        }

        if (leftRacer < rightRacer) {
            System.out.printf("The winner is left with total time: %.1f", leftRacer);
        } else {
            System.out.printf("The winner is right with total time: %.1f", rightRacer);
        }
    }
}
