import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String string = String.join("", scan.nextLine().split("\\s+"));

        Map<Character, Integer> counts = new LinkedHashMap<>();

        for (int i = 0; i < string.length(); i++) {
            counts.putIfAbsent(string.charAt(i), 0);
            counts.put(string.charAt(i), counts.get(string.charAt(i)) + 1);
        }

        for (var entry: counts.entrySet()) {
            System.out.println(String.format("%c -> %d",
                    entry.getKey(),
                    entry.getValue()));
        }
    }
}
