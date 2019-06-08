import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];
            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }

        continents.forEach((continent, countries) -> {
            System.out.println(continent + ":");
            countries.forEach((country, cities) -> System.out.println(String.format(" %s -> %s",
                    country, String.join(", ", cities))));
        });
    }
}
