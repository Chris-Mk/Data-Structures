import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SnowWhite {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();

        String input;
        while (!"Once upon a time".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+<::>\\s+");

            String name = data[0];
            String color = data[1];
            int physics = Integer.parseInt(data[2]);

            if (!dwarfs.containsKey(color)) {
                dwarfs.put(color, new LinkedHashMap<>());
                dwarfs.get(color).put(name, physics);
            } else {
                if (dwarfs.containsKey(color) && dwarfs.get(color).containsKey(name)) {
                    if (dwarfs.get(color).get(name) < physics) {
                        dwarfs.get(color).put(name, physics);
                    }
                }
            }
        }

        //Map<String, Integer> physics = new LinkedHashMap<>();
    }
}
