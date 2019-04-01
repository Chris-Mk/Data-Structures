import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        Map<String, Double> results = new TreeMap<>();

        for (Map.Entry<String, List<Double>> listEntry : students.entrySet()) {
            results.put(
                    listEntry.getKey(),
                    listEntry.getValue()
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .getAsDouble());
        }

        results.entrySet()
                .stream()
                .filter(e -> e.getValue() >= 4.50)
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> System.out.println(
                        String.format("%s -> %.2f",
                                e.getKey(),
                                e.getValue())
                ));
    }
}