import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String input;
        while (!"Revision".equals(input = scan.nextLine())) {
            String[] data = input.split(",\\s+");
            String name = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);
            shops.putIfAbsent(name, new LinkedHashMap<>());
            shops.get(name).put(product, price);
        }

        shops.forEach((shop, products) -> {
            System.out.println(String.format("%s->", shop));
            products.forEach((prod, price) -> System.out.println
                    (String.format("Product: %s, Price: %.1f",
                    prod, price)));
        });
    }
}
