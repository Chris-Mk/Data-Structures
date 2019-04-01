import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> companies = new TreeMap<>();

        String input;

        while (!"End".equals(input = scan.nextLine())) {
            String[] data = input.split(" -> ");

            String name = data[0];
            String id = data[1];

            if (!companies.containsKey(name)) {
                companies.put(name, new ArrayList<>());

                if (!companies.get(name).contains(id)) {
                    companies.get(name).add(id);
                }
            } else {
                if (!companies.get(name).contains(id)) {
                    companies.get(name).add(id);
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : companies.entrySet()) {
            System.out.println(entry.getKey());

            entry.getValue().forEach(e -> System.out.println(
                    String.format("-- %s", e)));

        }
    }
}
