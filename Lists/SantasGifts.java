package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasGifts {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<String> houseNumbers = Arrays
                .stream(scan.nextLine().split("\\s"))
                .collect(Collectors.toList());

        int santaPosition = 0;

        for (int i = 0; i < n; i++) {
            String[] commands = scan.nextLine().split("\\s+");

            switch (commands[0]) {
                case "Forward":
                    int forwardSteps = Integer.parseInt(commands[1]);

                    if (santaPosition + forwardSteps < houseNumbers.size()) {
                        santaPosition += forwardSteps;
                        houseNumbers.remove(santaPosition);
                    }
                    break;
                case "Back":
                    int backSteps = Integer.parseInt(commands[1]);

                    if (santaPosition - backSteps >= 0) {
                        santaPosition -= backSteps;
                        houseNumbers.remove(santaPosition);
                    }
                    break;
                case "Gift":
                    int index = Integer.parseInt(commands[1]);

                    if (index >= 0 && index < houseNumbers.size()) {
                        houseNumbers.add(index, commands[2]);
                        santaPosition = index;
                    }
                    break;
                case "Swap":
                    if (houseNumbers.contains(commands[1]) && houseNumbers.contains(commands[2])) {
                        int firstHouseIndex = houseNumbers.indexOf(commands[1]);
                        int secondHouseIndex = houseNumbers.indexOf(commands[2]);

                        houseNumbers.set(firstHouseIndex, commands[2]);
                        houseNumbers.set(secondHouseIndex, commands[1]);
                    }
                    break;
            }
        }

        System.out.println("Position: " + santaPosition);
        System.out.println(houseNumbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
