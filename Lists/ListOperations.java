package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"End".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");

            switch (data[0]) {
                case "Add":
                    numbers.add(data[1]);
                    break;

                case "Insert":
                    int index = Integer.parseInt(data[2]);

                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, data[1]);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Remove":
                    int index1 = Integer.parseInt(data[1]);

                    if (index1 >= 0 && index1 < numbers.size()) {
                        numbers.remove(index1);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Shift":
                    int count = Integer.parseInt(data[2]);

                    switch (data[1]) {
                        case "left":
                            for (int i = 0; i < count; i++) {
                                numbers.add(numbers.get(0));
                                numbers.remove(0);
                            }
                            break;

                        case "right":
                            for (int i = 0; i < count; i++) {
                                numbers.add(0, numbers.get(numbers.size() - 1));
                                numbers.remove(numbers.size() - 1);
                            }
                            break;
                    }
                    break;
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
