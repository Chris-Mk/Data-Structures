import java.util.*;

public class Courses {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input;

        while (!"end".equals(input = scan.nextLine())) {
            String[] data = input.split(" : ");

            String name = data[0];
            String student = data[1];

            courses.putIfAbsent(name, new ArrayList<>());
            courses.get(name).add(student);
        }

        courses.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("%s: %d\n", e.getKey(), e.getValue().size());

                    e.getValue()
                            .stream()
                            .sorted(Comparator.naturalOrder())
                            .forEach(name -> System.out.printf("-- %s\n", name));
                });
    }
}
