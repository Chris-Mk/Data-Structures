import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }

        for (var entry : words.entrySet()) {
            System.out.printf("%s - %s\n",
                    entry.getKey(),
                    entry.getValue()
                            .toString()
                            .replaceAll("[\\[\\]]", ""));
        }
    }
}
