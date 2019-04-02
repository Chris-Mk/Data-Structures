package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> elements = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"3:1".equals(input = scan.nextLine())) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    startIndex = validateIndex(startIndex, elements.size());
                    endIndex = validateIndex(endIndex, elements.size());

                    String concatElements = String.join("", elements.subList(startIndex, endIndex + 1));
                    elements.subList(startIndex, endIndex + 1).clear();
                    elements.add(startIndex, concatElements);
                    break;
                case "divide":
                    int index = Integer.parseInt(command[1]);
                    int partitions = Integer.parseInt(command[2]);

                    List<String> result = dividedEqually(elements.get(index), partitions);
                    elements.remove(index);
                    elements.addAll(index, result);
                    break;
            }
        }

        System.out.println(String.join(" ", elements));
    }

    private static List<String> dividedEqually(String element, int partitions) {
        int part = element.length() / partitions;
        List<String> result = new ArrayList<>();

        while (element.length() >= part) {
            result.add(element.substring(0, part));
            element = element.substring(part);
        }

        if (!element.equals("")) {
            result.add(element);
        }

        if (result.size() == partitions) {
            return result;
        } else {
            String concatLastElements = result.get(result.size() - 2)
                    .concat(result.get(result.size() - 1));

            result.subList(result.size() - 2, result.size()).clear();
            result.add(concatLastElements);
            return result;
        }
    }

    private static int validateIndex(int index, int length) {
        if (index < 0) {
            index = 0;
        }

        if (index > length - 1) {
            index = length - 1;
        }

        return index;
    }
}
