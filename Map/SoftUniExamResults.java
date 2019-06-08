import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Integer> students = new LinkedHashMap<>();
        Map<String, Integer> languages = new LinkedHashMap<>();

        String input;
        while (!"exam finished".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s*-\\s*");

            String name = data[0];
            String language = data[1];

            if (language.equals("banned")) {
                students.remove(name);
            } else {
                int score = Integer.parseInt(data[2]);

                if (!students.containsKey(name)) {
                    students.put(name, score);
                }

                if (students.get(name) < score) {
                    students.put(name, score);
                }

                if (!languages.containsKey(language)) {
                    languages.putIfAbsent(language, 0);
                }

                languages.put(language, languages.get(language) + 1);
            }
        }

        System.out.println("Results:");
        students.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());

                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }

                    return sort;
                })
                .forEach(e -> {
                    System.out.println(String.format("%s | %d",
                            e.getKey(),
                            e.getValue()));
                });

        System.out.println("Submissions:");
        languages.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());

                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }

                    return sort;
                })
                .forEach(e -> {
                    System.out.println(String.format("%s - %d",
                            e.getKey(),
                            e.getValue()));
                });
    }
}
