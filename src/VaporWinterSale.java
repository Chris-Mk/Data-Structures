package AssociativeArrays;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VaporWinterSale {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] games = scan.nextLine().split(",\\s");

        Map<String, Double> gamesAndPrices = new LinkedHashMap<>();
        Map<String, String> gamesAndDlc = new LinkedHashMap<>();

        for (String game : games) {
            String[] data = game.split("[-:]");
            String name = data[0];

            if (game.contains("-")) {
                double price = Double.parseDouble(data[1]);
                gamesAndPrices.putIfAbsent(name, price);

            } else if (game.contains(":")) {
                String dlc = data[1];

                if (gamesAndPrices.containsKey(name)) {
                    gamesAndDlc.put(name, dlc);
                    gamesAndPrices.put(name, gamesAndPrices.get(name) * 1.20);
                }
            }
        }

        for (var gameAndPrice : gamesAndPrices.entrySet()) {
            if (!gamesAndDlc.containsKey(gameAndPrice.getKey())) {
                gamesAndPrices.put(gameAndPrice.getKey(), gamesAndPrices.get(gameAndPrice.getKey()) * .80);
            } else {
                gamesAndPrices.put(gameAndPrice.getKey(), gamesAndPrices.get(gameAndPrice.getKey()) * .50);
            }
        }

        gamesAndPrices.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .forEach(e -> {
                    if (gamesAndDlc.containsKey(e.getKey())) {
                        System.out.println(String.format("%s - %s - %.2f",
                                e.getKey(),
                                gamesAndDlc.get(e.getKey()),
                                e.getValue()));
                    }
                });

        gamesAndPrices.entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> {
                    if (!gamesAndDlc.containsKey(e.getKey())) {
                        System.out.println(String.format("%s - %.2f",
                                e.getKey(),
                                e.getValue()));
                    }
                });
    }
}
