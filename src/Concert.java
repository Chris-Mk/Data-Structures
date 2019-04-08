package AssociativeArrays;

import java.util.*;

public class Concert {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String commands;

        Map<String, List<String>> membersList = new LinkedHashMap<>();
        Map<String, Integer> playTime = new LinkedHashMap<>();
        int totalTime = 0;

        while (!"start of concert".endsWith(commands = scan.nextLine())) {
            String[] data = commands.split(";\\s+");
            String bandName = data[1];

            if (data[0].equals("Add")) {
                String[] bandMembers = data[2].split(",\\s+");

                if (!membersList.containsKey(bandName)) {
                    membersList.put(bandName, new LinkedList<>());

                    for (String bandMember : bandMembers) {
                        membersList.get(bandName).add(bandMember);
                    }
                } else {
                    for (String bandMember : bandMembers) {
                        if (!membersList.get(bandName).contains(bandMember)) {
                            membersList.get(bandName).add(bandMember);
                        }
                    }
                }
            } else if (data[0].equals("Play")) {
                int time = Integer.parseInt(data[2]);
                totalTime += time;

                if (!playTime.containsKey(bandName)) {
                    playTime.put(bandName, time);
                } else {
                    playTime.put(bandName, playTime.get(bandName) + time);
                }
            }
        }

        System.out.println(String.format("Total time: %d", totalTime));

        playTime.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());

                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }

                    return sort;
                })
                .forEach(e -> System.out.println(String.format("%s -> %d",
                        e.getKey(), e.getValue())));

        String topBand = scan.nextLine();

        System.out.println(topBand);
        membersList.get(topBand).forEach(e -> System.out.println(String.format("=> %s", e)));
    }
}
