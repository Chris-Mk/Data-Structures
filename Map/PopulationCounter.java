import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {

        Map<String, Map<String, Long>> populationCounter = new LinkedHashMap<>();
        Scanner scan = new Scanner(System.in);
        String input;

        while (!"report".equals(input = scan.nextLine())) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);
            populationCounter.putIfAbsent(country, new LinkedHashMap<>());
            populationCounter.get(country).put(city, population);
        }

        populationCounter.entrySet()
                .stream()
                .sorted((c1, c2) -> Long.compare(c2.getValue().values().stream().mapToLong(Long::longValue).sum(),
                        c1.getValue().values().stream().mapToLong(Long::longValue).sum()))
                .forEach(e -> {
                    System.out.println(String.format("%s (total population: %d)",
                            e.getKey(),
                            e.getValue().values().stream().mapToLong(Long::longValue).sum()));

                    e.getValue().entrySet()
                            .stream()
                            .sorted((v1, v2) -> Long.compare(v2.getValue(), v1.getValue()))
                            .forEach(c -> System.out.println(String.format("=>%s: %d", c.getKey(), c.getValue())));
                });
    }
}
