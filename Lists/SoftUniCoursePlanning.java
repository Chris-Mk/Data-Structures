package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> courses = Arrays
                .stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"course start".equals(input = scan.nextLine())) {
            String[] data = input.split(":");

            switch (data[0]) {
                case "Add":
                    if (!courses.contains(data[1])) {
                        courses.add(data[1]);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(data[2]);

                    if (!courses.contains(data[1])) {
                        if (index >= 0 && index < courses.size()) {
                            courses.add(index,data[1]);
                        }
                    }
                    break;
                case "Remove":
                    courses.remove(data[1]);

                    int indexOfData1 = courses.indexOf(data[1]);

                    if (indexOfData1 + 1 < courses.size()) {
                        if (courses.get(indexOfData1 + 1).contains(data[1])) {
                            courses.remove(indexOfData1 + 1);
                        }
                    }
                    break;
                case "Swap":
                    int firstIndex = courses.indexOf(data[1]);
                    int secondIndex = courses.indexOf(data[2]);

                    if (courses.contains(data[1]) && courses.contains(data[2])) {
                        courses.set(firstIndex, data[2]);
                        courses.set(secondIndex, data[1]);
                    }

                    if (firstIndex + 1 < courses.size()) {
                        if (courses.get(firstIndex + 1).contains(data[1])) {
                            courses.add(secondIndex + 1, courses.get(firstIndex + 1));
                            courses.remove(firstIndex + 2);
                        }
                    }

                    if (secondIndex + 1 < courses.size()) {
                        if (courses.get(secondIndex + 1).contains(data[2])) {
                            courses.add(firstIndex + 1, courses.get(secondIndex + 1));
                            courses.remove(secondIndex + 2);
                        }
                    }
                    break;
                case "Exercise":
                    int courseIndex = courses.indexOf(data[1]);

                    if (courses.contains(data[1])) {
                        if (!courses.get(courseIndex + 1).contains("Exercise")) {
                            courses.add(courseIndex + 1, data[1] + "-Exercise");
                        }
                    } else {
                        courses.add(data[1]);
                        courses.add(data[1] + "-Exercise");
                    }
                    break;
            }
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, courses.get(i));
        }
    }
}
