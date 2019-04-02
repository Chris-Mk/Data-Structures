package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String line = scan.nextLine();

            if (line.equals("end")) {
                break;
            }
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Contains":
                    int element = Integer.parseInt(tokens[1]);

                    System.out.println(list.contains(element) ? "Yes" : "No such number");
                    break;

                case "Print":
                    String type = tokens[1];

                    switch (type) {
                        case "even":
                            System.out.println(list.stream().filter(e -> e % 2 == 0)
                                    .collect(Collectors.toList())
                                    .toString().replaceAll("[\\[\\],]", ""));
                            break;
                        case "odd":
                            System.out.println(list.stream().filter(e -> e % 2 != 0)
                                    .collect(Collectors.toList())
                                    .toString().replaceAll("[\\[\\],]", ""));
                            break;
                    }
                    break;

                case "Get":
                    System.out.println(list.stream().mapToInt(Integer::intValue).sum());
                    break;

                case "Filter":
                    String condition = tokens[1];
                    int number = Integer.parseInt(tokens[2]);

                    switch (condition) {
                        case ">":
                            System.out.println(list.stream().filter(e -> e > number)
                                    .collect(Collectors.toList())
                                    .toString().replaceAll("[\\[\\],]", ""));
                            break;
                        case "<":
                            System.out.println(list.stream().filter(e -> e < number)
                                    .collect(Collectors.toList())
                                    .toString().replaceAll("[\\[\\],]", ""));
                            break;
                        case ">=":
                            System.out.println(list.stream().filter(e -> e >= number)
                                    .collect(Collectors.toList())
                                    .toString().replaceAll("[\\[\\],]", ""));
                            break;
                        case "<=":
                            System.out.println(list.stream().filter(e -> e <= number)
                                    .collect(Collectors.toList())
                                    .toString().replaceAll("[\\[\\],]", ""));
                            break;
                    }
            }
        }
    }
}
