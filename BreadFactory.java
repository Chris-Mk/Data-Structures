package Arrays;

import java.util.Scanner;

public class BreadFactory {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String[] events = scan.nextLine().split("\\|+");

        int energy = 100, coins = 100;

        for (String event : events) {
            String[] data = event.split("-+");

            String command = data[0];
            int num = Integer.parseInt(data[1]);

            if (command.equals("rest")) {
                int currentEnergy = energy;
                energy += num;

                if (energy > 100) {
                    num = 100 - currentEnergy;
                    energy = 100;
                }

                System.out.printf("You gained %d energy.\nCurrent energy: %d.\n", num, energy);

            } else if (command.equals("order")) {
                int currentEnergy = energy;
                energy -= 30;

                if (energy < 0) {
                    System.out.println("You had to rest!");
                    energy = currentEnergy + 50;
                    continue;
                }

                coins += num;
                System.out.printf("You earned %d coins.\n", num);

            } else {
                coins -= num;

                if (coins > 0) {
                    System.out.printf("You bought %s.\n", command);
                } else {
                    System.out.printf("Closed! Cannot afford %s.", command);
                    return;
                }
            }
        }

        System.out.printf("Day completed!\nCoins: %d\nEnergy: %d", coins, energy);
    }
}
