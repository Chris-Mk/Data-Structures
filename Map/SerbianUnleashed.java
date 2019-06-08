import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {

        Map<String, Map<String, Integer>> stats = new LinkedHashMap<>();
        Scanner scan = new Scanner(System.in);
        String input;

        while (!"End".equals(input = scan.nextLine())) {
            Pattern pattern = Pattern.compile("^(?<singer>[\\w\\s]+) @(?<venue>[\\w\\s]+) (?<price>\\d+) (?<count>\\d+)$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));

                stats.putIfAbsent(venue, new LinkedHashMap<>());
                stats.get(venue).putIfAbsent(singer, 0);
                stats.get(venue).put(singer, stats.get(venue).get(singer) + price * count);
            }
        }

        stats.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet()
                    .stream()
                    .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                    .forEach(e -> System.out.println(String.format("#  %s -> %d", e.getKey(), e.getValue())));
        });
    }
}
