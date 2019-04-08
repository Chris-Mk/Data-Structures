package Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> words = Arrays
                .stream(scan.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"Stop".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");

            switch (data[0]) {
                case "Delete":
                    int index = Integer.parseInt(data[1]);

                    if (index >= -1 && index < words.size() - 1) {
                        words.remove(index + 1);
                    }
                    break;
                case "Swap":
                    int firstIndex = words.indexOf(data[1]);
                    int secondIndex = words.indexOf(data[2]);

                    if (firstIndex != -1 && secondIndex != -1) {
                        words.set(firstIndex, data[2]);
                        words.set(secondIndex, data[1]);
                    }
                    break;
                case "Put":
                    int givenIndex = Integer.parseInt(data[2]);

                    if (givenIndex - 1 >= 0 && givenIndex - 2 < words.size()) {
                        words.add(givenIndex - 1, data[1]);
                    }
                    break;
                case "Sort":
                    words = words.stream()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toList());
                    break;
                case "Replace":
                    List<String> finalWords = words;

                    words.stream()
                            .filter(e -> e.equals(data[2]))
                            .findAny()
                            .map(e -> finalWords.set(finalWords.indexOf(e), data[1]));
                    break;
            }
        }

        System.out.print(words.toString().replaceAll("[\\[\\],]", ""));
    }
}
