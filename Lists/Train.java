package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> passengers = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scan.nextLine());

        String command;
        while (!"end".equals(command = scan.nextLine())) {
            String[] data = command.split(" ");

            if (data[0].equals("Add")) {
                passengers.add(Integer.parseInt(data[1]));
            } else {

                for (int i = 0; i < passengers.size(); i++) {
                    if (Integer.parseInt(data[0]) + passengers.get(i) <= maxCapacity) {
                        passengers.set(i, Integer.parseInt(data[0]) + passengers.get(i));
                        break;
                    }
                }
            }
        }

        System.out.println(passengers.toString().replaceAll("[\\[,\\]]", ""));
    }
}
