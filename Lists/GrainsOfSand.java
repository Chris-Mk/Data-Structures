package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrainsOfSand {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> elements = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command;

        while (!"Mort".equals(command = scan.nextLine())) {
            String[] data = command.split("\\s+");

            switch (data[0]) {
                case "Add":
                    elements.add(Integer.parseInt(data[1]));
                    break;
                case "Remove":
                    if (elements.contains(Integer.parseInt(data[1]))) {
                        elements.stream()
                                .filter(e -> e == Integer.parseInt(data[1]))
                                .findFirst()
                                .map(elements::remove);
                    } else {
                        if (Integer.parseInt(data[1]) > 0 && Integer.parseInt(data[1]) < elements.size()) {
                            elements.remove(Integer.parseInt(data[1]));
                        }
                    }
                    break;
                case "Replace":
                    if (elements.contains(Integer.parseInt(data[1]))) {
                        List<Integer> finalElements = elements;

                        elements.stream()
                                .filter(e -> e == Integer.parseInt(data[1]))
                                .findFirst()
                                .map(e -> finalElements.set(finalElements.indexOf(e), Integer.parseInt(data[2])));
                    }
                    break;
                case "Increase":
                    int value = elements.stream()
                            .filter(e -> e >= Integer.parseInt(data[1]))
                            .findFirst()
                            .orElse(elements.get(elements.size() - 1));

                    elements = elements.stream()
                            .map(e -> e + value)
                            .collect(Collectors.toList());
                    break;
                case "Collapse":
                    elements.removeIf( e -> e < Integer.parseInt(data[1]));
                    break;
            }
        }

        System.out.println(elements.toString().replaceAll("[\\[\\],]", ""));
    }
}

