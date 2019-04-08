package AssociativeArrays;

import java.util.*;

public class MeTubeStatistics {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Integer> views = new HashMap<>();
        Map<String, Integer> likes = new HashMap<>();

        String input;

        while (!"stats time".equals(input = scan.nextLine())) {
            String[] data = input.split("[-:]");

            String firstToken = data[0];

            if (firstToken.equals("like")) {
                String secondToken = data[1];

                if (views.containsKey(secondToken)) {
                    likes.put(secondToken, likes.get(secondToken) + 1);
                }
            } else if (firstToken.equals("dislike")) {
                String secondToken = data[1];

                if (views.containsKey(secondToken)) {
                    likes.put(secondToken, likes.get(secondToken) - 1);
                }
            } else {
                int secondToken = Integer.parseInt(data[1]);

                if (!views.containsKey(firstToken)) {
                    views.put(firstToken, secondToken);
                    likes.put(firstToken, 0);
                } else {
                    views.put(firstToken, views.get(firstToken) + secondToken);
                }
            }
        }

        String stats = scan.nextLine();

        if (stats.equals("by views")) {
            views.entrySet()
                    .stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(e -> System.out.println(
                            String.format("%s - %d views - %d likes",
                            e.getKey(),
                            e.getValue(),
                            likes.get(e.getKey()))));
        } else if (stats.equals("by likes")) {
            likes.entrySet()
                    .stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(e -> System.out.println(
                            String.format("%s - %d views - %d likes",
                            e.getKey(),
                            views.get(e.getKey()),
                            e.getValue())));
        }
    }
}
