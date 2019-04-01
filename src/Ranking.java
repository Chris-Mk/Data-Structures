import java.util.*;
import java.util.stream.Collectors;

public class Ranking {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, String> contests = new LinkedHashMap<>();

        String input;
        while (!"end of contests".equals(input = scan.nextLine())) {
            String[] data = input.split(":");

            String contest = data[0];
            String password = data[1];

            contests.putIfAbsent(contest, password);
        }

        Map<String, Map<String, Integer>> results = new LinkedHashMap<>();

        String tokens;
        while (!"end of submissions".equals(tokens = scan.nextLine())) {
            String[] data = tokens.split("=>");

            String contest = data[0];
            String password = data[1];
            String username = data[2];
            int points = Integer.parseInt(data[3]);

            if (contests.containsKey(contest) && contests.get(contest).equals(password)) {
                if (results.containsKey(username) && !results.get(username).containsKey(contest)) {
                    results.get(username).put(contest, points);
                } else {
                    if (!results.containsKey(username)) {
                        results.put(username, new LinkedHashMap<>());
                        results.get(username).put(contest, points);
                    }
                }

                if (results.containsKey(username) && results.get(username).get(contest) < points) {
                    results.get(username).put(contest, points);
                }
            }
        }

        Map<String, Integer> winner = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : results.entrySet()) {
            winner.put(entry.getKey(), entry.getValue()
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum());
        }

        winner.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(1)
                .forEach(e -> System.out.println(
                        String.format("Best candidate is %s with total %d points.",
                                e.getKey(), e.getValue())));

        System.out.println("Ranking: ");

        results = results.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> {throw  new AssertionError();},
                        LinkedHashMap::new)
                );

        for (var entry : results.entrySet()) {
            System.out.println(entry.getKey());

            entry.getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(e -> System.out.println(String.format("#  %s -> %d", e.getKey(), e.getValue())));
        }
    }
}
