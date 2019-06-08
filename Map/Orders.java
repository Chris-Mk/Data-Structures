import java.util.*;

public class Orders {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Integer> productsAndQuantity = new LinkedHashMap<>();
        Map<String, Double> productAndPrice = new LinkedHashMap<>();

        String input;

        while (!"buy".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s");

            String name = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            if (!productsAndQuantity.containsKey(name)) {
                productsAndQuantity.put(name, quantity);
                productAndPrice.put(name, price);
            } else {
                productsAndQuantity.put(name, productsAndQuantity.get(name) + quantity);

                if (productAndPrice.get(name) != price) {
                    productAndPrice.put(name, price);
                }
            }
        }

        Map<String, Double> result = new LinkedHashMap<>();

        for (String s : productAndPrice.keySet()) {
            if (productsAndQuantity.containsKey(s)) {
                result.put(s, productAndPrice.get(s) * productsAndQuantity.get(s));
            }
        }

        result.forEach((key, value) -> System.out.printf("%s -> %.2f\n", key, value));
    }
}
