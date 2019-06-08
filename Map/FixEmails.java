import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();

        String name;
        while (!"stop".equals(name = scan.nextLine())) {
            String email = scan.nextLine();
            emails.putIfAbsent(name, email);
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            if (entry.getValue().toLowerCase().endsWith("us")
                    || entry.getValue().toLowerCase().endsWith("uk")
                    || entry.getValue().toLowerCase().endsWith("com")) {
                continue;
            }
            System.out.println(String.format("%s -> %s", entry.getKey(), entry.getValue()));
        }
    }
}
