import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String input;

        while (!"stop".equals(input = scan.nextLine())) {
            int quantity = Integer.parseInt(scan.nextLine());

            resources.putIfAbsent(input, 0);
            resources.put(input, resources.get(input) + quantity);
        }

        for (var resource : resources.entrySet()) {
            System.out.println(String.format("%s -> %d",
                    resource.getKey(),
                    resource.getValue()));
        }
    }
}
