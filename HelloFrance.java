package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class HelloFrance {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] items = scan.nextLine().split("\\|");

        double budget = Double.parseDouble(scan.nextLine());

        double[] newPrices = new double[items.length];
        double profit = 0d;

        for (int i = 0; i < items.length; i++) {
            String[] item = items[i].split("->");

            String product = item[0];
            double price = Double.parseDouble(item[1]);

            if (product.equals("Clothes") && price <= 50.00) {
                if (budget >= price) {
                    budget -= price;
                    newPrices[i] = price * 1.40;
                    profit += newPrices[i] - price;
                }
            } else if (product.equals("Shoes") && price <= 35.00) {
                if (budget >= price) {
                    budget -= price;
                    newPrices[i] = price * 1.40;
                    profit += newPrices[i] - price;
                }
            } else if (product.equals("Accessories") && price <= 20.50) {
                if (budget >= price) {
                    budget -= price;
                    newPrices[i] = price * 1.40;
                    profit += newPrices[i] - price;
                }
            }
        }

        newPrices = Arrays.stream(newPrices).filter(e -> e != 0).toArray();

        for (double newPrice : newPrices) {
            System.out.printf("%.2f ", newPrice);
        }

        System.out.println();

        System.out.printf("Profit: %.2f\n", profit);

        budget += Arrays.stream(newPrices).sum();

        if (budget >= 150) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }
    }
}
