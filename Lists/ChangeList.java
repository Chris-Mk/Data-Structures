package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"end".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Delete":
                    numbers.removeIf(e -> e.equals(data[1]));
                    break;
                case "Insert":
                    String element = data[1];
                    int position = Integer.parseInt(data[2]);

                    if (position >= 0 && position < numbers.size()) {
                        numbers.add(position, element);
                    }
                    break;
            }
        }

        System.out.println(String.join(" ",
                numbers
                        .toString().
                        replaceAll("[\\[\\],]", "")));
    }
}
