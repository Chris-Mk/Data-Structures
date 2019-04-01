import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Integer> keyMaterial = new LinkedHashMap<>();
        keyMaterial.put("shards", 0);
        keyMaterial.put("fragments", 0);
        keyMaterial.put("motes", 0);

        Map<String, Integer> junks = new TreeMap<>();

        String winner = "";
        boolean flag = false;

        do {
            String[] data = scan.nextLine().split("\\s+");

            for (int i = 0; i < data.length; i += 2) {
                int quantity = Integer.parseInt(data[i]);
                String material = data[i + 1].toLowerCase();

                if (!keyMaterial.containsKey(material)) {
                    if (!junks.containsKey(material)) {
                        junks.put(material, quantity);
                    } else {
                        junks.put(material, junks.get(material) + quantity);
                    }
                } else {
                    keyMaterial.put(material, keyMaterial.get(material) + quantity);

                    if (keyMaterial.get(material) >= 250) {
                        flag = true;
                        winner = material;
                        keyMaterial.put(material, keyMaterial.get(material) - 250);
                        break;
                    }
                }
            }
        } while (!flag);

        if (winner.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (winner.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        } else if (winner.equals("motes")) {
            System.out.println("Dragonwrath obtained!");
        }

        keyMaterial.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());

                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }

                    return sort;
                 })
                .forEach(entry -> System.out.println(String.format("%s: %d",
                        entry.getKey(),
                        entry.getValue())));

        junks
                .forEach((key, value) -> System.out.println(String.format("%s: %d",
                        key, value)));
    }
}
