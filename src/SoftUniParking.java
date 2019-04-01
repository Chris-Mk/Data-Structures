import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, String> registered = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");

            String command = data[0];

            if (command.equals("register")) {
                String name = data[1];
                String number = data[2];

                if (!registered.containsKey(name)) {
                    registered.put(name, number);
                    System.out.printf("%s registered %s successfully\n", name, number);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s\n", registered.get(name));
                }
            } else if (command.equals("unregister")){
                String name = data[1];

                if (registered.containsKey(name)) {
                    registered.remove(name);
                    System.out.printf("%s unregistered successfully\n", name);
                } else {
                    System.out.printf("ERROR: user %s not found\n", name);
                }
            }
        }

        registered.forEach((key, value) -> System.out.println(
                String.format("%s => %s", key, value)));
    }
}
