package Arrays;

import java.util.Scanner;

public class DungeonestDark {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] rooms = scan.nextLine().split("\\|");
        int health = 100, coins = 0;

        for (int i = 0; i < rooms.length; i++) {
            String[] command = rooms[i].split("\\s+");

            if (command[0].equals("potion")) {
                int currentHeath = health;
                health += Integer.parseInt(command[1]);

                if (health > 100) {
                    command[1] = String.valueOf(100 - currentHeath);
                    health = 100;
                }
                System.out.printf("You healed for %s hp.\nCurrent health: %d hp.\n", command[1], health) ;

            } else if (command[0].equals("chest")) {
                coins += Integer.parseInt(command[1]);
                System.out.printf("You found %s coins.\n", command[1]);
            } else {
                health -= Integer.parseInt(command[1]);

                if (health > 0) {
                    System.out.printf("You slayed %s.\n", command[0]);
                } else {
                    System.out.printf("You died! Killed by %s.\n", command[0]);
                    System.out.printf("Best room: %d", ++i);
                    return;
                }
            }
        }

        System.out.printf("You've made it!\nCoins: %d\nHealth: %d", coins, health);
    }
}
