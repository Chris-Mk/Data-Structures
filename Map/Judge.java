import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> results = new LinkedHashMap<>();

        String input;
        while (!"no more time".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+->\\s+");

            String username = data[0];
            String contest = data[1];
            int points = Integer.parseInt(data[2]);

            if (!results.containsKey(contest)) {
                results.put(contest, new LinkedHashMap<>());
                results.get(contest).put(username, points);
            } else {
                if (!results.get(contest).containsKey(username)) {
                    results.get(contest).put(username, points);
                } else {
                    if (results.get(contest).get(username) < points) {
                        results.get(contest).put(username, points);
                    }
                }
            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().keySet().size() + " participants");

            AtomicInteger index = new AtomicInteger();
            entry.getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1,e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(e -> System.out.println(index.incrementAndGet() + ". " + e.getKey() + " <::> " + e.getValue()));
        }

        System.out.println("Individual standings:");
        Map<String, Integer> individualStats = new LinkedHashMap<>();

        for (Map<String, Integer> entry : results.values()) {
            entry.forEach((key, value) -> {
                if (individualStats.containsKey(key)) {
                    individualStats.put(key, individualStats.get(key) + value);
                } else {
                    individualStats.put(key, value);
                }
            });
        }

        AtomicInteger index = new AtomicInteger(1);
        individualStats.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> System.out.println(index.getAndIncrement() + ". " + e.getKey() + " -> " + e.getValue()));
    }
}
