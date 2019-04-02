package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> integerList = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;

        while (!"end".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Add":
                    String element = data[1];
                    integerList.add(element);
                    break;
                case "Remove":
                    String element1 = data[1];
                    integerList.remove(element1);
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(data[1]);
                    integerList.remove(index);
                    break;
                case "Insert":
                    String element2 = data[1];
                    int index1 = Integer.parseInt(data[2]);
                    integerList.add(index1, element2);
                    break;
            }
        }

        System.out.println(integerList.toString().replaceAll("[\\[,\\]]", ""));
    }
}
