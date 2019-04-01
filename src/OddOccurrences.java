import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split("\\s+");

        Map<String, Integer> occurrences = new LinkedHashMap<>();

        for (String currentWord : words) {
            String wordToLowerCase = currentWord.toLowerCase();

            occurrences.putIfAbsent(wordToLowerCase, 0);
            occurrences.put(wordToLowerCase, occurrences.get(wordToLowerCase) + 1);
        }

        List<String> odds = new ArrayList<>();

        for (var entry : occurrences.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", odds));
    }
}
