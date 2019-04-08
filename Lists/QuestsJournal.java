package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> quests = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        String command;
        while (!"Retire!".equals(command = scan.nextLine())) {
            String[] data = command.split(" - ");

            switch (data[0]) {
                case "Start":
                    if (!quests.contains(data[1])) {
                        quests.add(data[1]);
                    }
                    break;
                case "Complete":
                    quests.remove(data[1]);
                    break;
                case "Side Quest":
                    String[] sideQuests = data[1].split(":");
                    int index = quests.indexOf(sideQuests[0]);

                    if (index != -1 && !quests.contains(sideQuests[1])) {
                        quests.add(index + 1, sideQuests[1]);
                    }
                    break;
                case "Renew":
                    if (quests.contains(data[1])) {
                        quests.remove(data[1]);
                        quests.add(data[1]);
                    }
                    break;
            }
        }

        System.out.println(quests.toString().replaceAll("[\\[\\]]", ""));
    }
}
