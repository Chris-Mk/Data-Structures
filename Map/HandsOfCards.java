import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input;
        while (!"JOKER".equals(input = scan.nextLine())) {
            String[] data = input.split(":\\s+");
            String name = data[0];
            Set<String> cards = Arrays.stream(data[1].split(",\\s+"))
                    .collect(Collectors.toSet());
            players.putIfAbsent(name, new LinkedHashSet<>());
            players.get(name).addAll(cards);
        }

        players.forEach((player, cards) -> {
            int totalValue = 0;
            for (String card : cards) {
                String power = card.startsWith("10") ? "10" : String.valueOf(card.charAt(0));
                String type = String.valueOf(card.charAt(card.length() - 1));

                int cardValue = switch (power) {
                    case "2" -> 2;
                    case "3" -> 3;
                    case "4" -> 4;
                    case "5" -> 5;
                    case "6" -> 6;
                    case "7" -> 7;
                    case "8" -> 8;
                    case "9" -> 9;
                    case "10" -> 10;
                    case "J" -> 11;
                    case "Q" -> 12;
                    case "K" -> 13;
                    case "A" -> 14;
                    default -> 0;
                };

                switch (type) {
                    case "S" -> cardValue *= 4;
                    case "H" -> cardValue *= 3;
                    case "D" -> cardValue *= 2;
                    case "C" -> cardValue *= 1;
                }
                totalValue += cardValue;
            }
            System.out.println(String.format("%s: %d", player, totalValue));
        });
    }
}
