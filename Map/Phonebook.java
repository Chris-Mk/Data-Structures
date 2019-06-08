import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {

        Map<String, String> phonebook = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        String input;
        while (!"search".equals(input = scan.nextLine())) {
            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];
            phonebook.putIfAbsent(name, "");
            phonebook.put(name, number);
        }

        String person;
        while (!"stop".equals(person = scan.nextLine())) {
            if (phonebook.containsKey(person)) {
                System.out.println(String.format("%s -> %s", person, phonebook.get(person)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", person));
            }
        }
    }
}
