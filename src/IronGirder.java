package AssociativeArrays;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class IronGirder {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Integer> times = new HashMap<>();
        Map<String, Integer> passengers = new HashMap<>();


        String input;
        while (!"Slide rule".equals(input = scan.nextLine())) {
            String[] data = input.split(":|->");

            String town = data[0];
            String time = data[1];
            int currentPassengers = Integer.parseInt(data[2]);

            if (!"ambush".equals(time)) {
                int minutes = Integer.parseInt(data[1]);

                if (!times.containsKey(town)) {
                    times.put(town, minutes);

                    if (!passengers.containsKey(town)) {
                        passengers.put(town, currentPassengers);
                    } else {
                        passengers.put(town, passengers.get(town) + currentPassengers);
                    }
                } else {
                    if (times.get(town) > minutes) {
                        times.put(town, minutes);
                    }

                    passengers.put(town, passengers.get(town) + currentPassengers);
                }
            } else {
                if (times.containsKey(town)) {
                    times.remove(town);
                    passengers.put(town, passengers.get(town) - currentPassengers);
                }
            }
        }

        times = times.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> {throw new AssertionError();},
                        HashMap::new
                ));

        passengers = passengers.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> {throw new AssertionError();},
                        HashMap::new
                ));

        Map<String, Integer> finalPassengers = passengers;
        times.entrySet()
                .stream()
                .sorted(Comparator.comparingInt((ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue)
                        .thenComparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(
                        String.format("%s -> Time: %d -> Passengers: %d",
                        e.getKey(),
                        e.getValue(),
                        finalPassengers.get(e.getKey()))));
    }
}
