import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSymbols {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character, Integer> characterCount = new LinkedHashMap<>();

        for (char ch : input.toCharArray()) {
            characterCount.putIfAbsent(ch, 0);
            characterCount.put(ch, characterCount.get(ch) + 1);
        }

        characterCount.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(ch -> System.out.println(String.format("%c: %d time/s",
                        ch.getKey(), ch.getValue())));
    }
}
