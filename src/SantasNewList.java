package AssociativeArrays;

import java.util.*;

public class SantasNewList {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String command;

        Map<String, Integer> children = new HashMap<>();
        Map<String, Integer> toys = new LinkedHashMap<>();

        while (!"END".equals(command = scan.nextLine())) {
            String[] elements = command.split("->");

            String firstToken = elements[0];
            String secondToken = elements[1];

            if (firstToken.equals("Remove")) {
                children.remove(secondToken);
            } else {
                int thirdToken = Integer.parseInt(elements[2]);

                if (!children.containsKey(firstToken)) {
                    children.put(firstToken, thirdToken);
                } else {
                    children.put(firstToken, children.get(firstToken) + thirdToken);
                }

                if (!toys.containsKey(secondToken)) {
                    toys.put(secondToken, thirdToken);
                } else {
                    toys.put(secondToken, toys.get(secondToken) + thirdToken);
                }
            }
        }

        System.out.println("Children: ");
        children.entrySet()
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

        System.out.println("Presents: ");
        toys.forEach((key, value) -> System.out.println(String.format("%s -> %d", key, value)));
    }
}
