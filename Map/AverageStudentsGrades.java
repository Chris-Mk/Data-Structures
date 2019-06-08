import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, ArrayList<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().trim().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.forEach((key, value) -> System.out.println(String.format("%s -> %s (avg: %.2f)",
                key,
                value.stream()
                        .map(e -> String.format("%.2f", e))
                        .collect(Collectors.joining(" ")),
                value.stream()
                        .collect(Collectors.averagingDouble(Double::doubleValue)))));
    }
}
