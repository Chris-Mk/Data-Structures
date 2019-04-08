package AssociativeArrays;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] elements = scan.nextLine().split(" \\| ");

        Map<String, List<String>> dictionary = new HashMap<>();

        for (String element : elements) {
            String[] data = element.split(": ");

            String word = data[0];
            String definitions = data[1];

            dictionary.putIfAbsent(word, new ArrayList<>());
            dictionary.get(word).add(definitions);
        }

        String[] words = scan.nextLine().split(" \\| ");

        for (String word : words) {
            if (dictionary.containsKey(word)) {
                System.out.println(word);

                dictionary.get(word)
                        .stream()
                        .sorted((e1, e2) -> Integer.compare(e2.length(), e1.length()))
                        .forEach(e -> System.out.println(String.format(" -%s", e)));
            }
        }

        String token = scan.nextLine();

        if (token.equals("List")) {
            dictionary.keySet()
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .forEach(e -> System.out.print(e + " "));
        }
    }
}
