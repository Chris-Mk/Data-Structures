package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command;

        while (!"END".equals(command = scan.nextLine())) {
            String[] input  = command.split("\\s+");

            switch (input[0]) {
                case "Change":
                    if (numbers.contains(input[1])) {

                        numbers.stream()
                                .filter(e -> e.equals(input[1]))
                                .findFirst()
                                .map(e -> numbers.set(numbers.indexOf(e), input[2]));
                    }
                    break;
                case "Hide":
                    if (numbers.contains(input[1])) {
                        numbers.stream()
                                .filter(e -> e.equals(input[1]))
                                .findFirst()
                                .map(numbers::remove);
                    }
                    break;
                case "Switch":
                    if (numbers.contains(input[1]) && numbers.contains(input[2])) {
                        int f2 = numbers.indexOf(input[2]);

                        numbers.set(numbers.indexOf(input[1]), input[2]);
                        numbers.set(f2, input[1]);
                    }
                    break;
                case "Insert":
                    if (numbers.size() > Integer.parseInt(input[1])) {
                        numbers.add(Integer.parseInt(input[1]) + 1, input[2]);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(numbers);
                    break;
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
