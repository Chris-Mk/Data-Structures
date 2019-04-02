package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double presentMoney = Double.parseDouble(scan.nextLine());

        List<Integer> initialDrumQualities = Arrays.stream(scan.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> drumPrices = new ArrayList<>(initialDrumQualities);

        String command;
        while (!"Hit it again, Gabsy!".equals(command = scan.nextLine())) {
            int power = Integer.parseInt(command);

            for (int i = 0; i < initialDrumQualities.size(); i++) {
                initialDrumQualities.set(i,initialDrumQualities.get(i) - power);

                if (initialDrumQualities.get(i) <= 0){
                    if (drumPrices.get(i) * 3 <= presentMoney) {
                        initialDrumQualities.set(i, drumPrices.get(i));
                        presentMoney -= drumPrices.get(i) * 3;
                    } else if (drumPrices.get(i) * 3 > presentMoney){
                        initialDrumQualities.remove(i);
                        drumPrices.remove(i);
                        i--;
                    }
                }
            }
        }

        System.out.println(initialDrumQualities.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", presentMoney);
    }
}
