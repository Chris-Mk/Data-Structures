import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MOBAChallenger {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> playerPool = new LinkedHashMap<>();

        String input;
        while (!"Season end".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+->\\s+|\\s+vs\\s+");

            if (input.contains("->")) {
                String player = data[0];
                String position = data[1];
                int skills = Integer.parseInt(data[2]);

                if (!playerPool.containsKey(player)) {
                    playerPool.put(player, new LinkedHashMap<>());
                    playerPool.get(player).put(position, skills);
                } else {
                    if (playerPool.get(player).containsKey(position) && playerPool.get(player).get(position) < skills) {
                        playerPool.get(player).put(position, skills);
                    } else {
                        playerPool.get(player).put(position, skills);
                    }
                }
            } else {
                String firstPlayer = data[0];
                String secondPlayer = data[1];

                if (playerPool.containsKey(firstPlayer) && playerPool.containsKey(secondPlayer)) {

                    for (String pos : playerPool.get(firstPlayer).keySet()) {
                        if (playerPool.get(secondPlayer).containsKey(pos)) {

                            if (playerPool.get(firstPlayer).values().stream().mapToInt(Integer::intValue).sum() <
                                    playerPool.get(secondPlayer).values().stream().mapToInt(Integer::intValue).sum()) {
                                playerPool.remove(firstPlayer);
                            } else {
                                playerPool.remove(secondPlayer);
                            }
                        }
                    }
                }
            }
        }

        Map<String, Integer> players = new LinkedHashMap<>();

        Map<String, Integer> finalPlayers = players;
        playerPool.forEach((key, value) -> finalPlayers.put(key, value
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum()));

        players = players.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());

                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }

                    return sort;
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, Integer> kvp : players.entrySet()) {
            System.out.println(String.format("%s: %d skill", kvp.getKey(), kvp.getValue()));

            for (Map.Entry<String, Map<String, Integer>> entry : playerPool.entrySet()) {
                if (kvp.getKey().equals(entry.getKey())) {
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int sort = Integer.compare(e2.getValue(), e1.getValue());

                                if (sort == 0) {
                                    sort = e1.getKey().compareTo(e2.getKey());
                                }

                                return sort;
                            }).forEach(e -> System.out.println(String.format("- %s <::> %d", e.getKey(), e.getValue())));
                }
            }
        }
    }
}
