package Arrays;

import java.util.Scanner;

public class SeizeTheFire {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] cells = scan.nextLine().split("#");
        int water = Integer.parseInt(scan.nextLine());

        String[] result = new String[cells.length];

        double energy = 0;
        int totalFire = 0, index = 0;

        for (String cell : cells) {
            String[] data = cell.split("\\s+=\\s+");

            String level = data[0];
            int value = Integer.parseInt(data[1]);

            switch (level) {
                case "High":
                    if (value >= 81 && value <= 125 && water >= value) {
                        result[index++] = String.valueOf(value);
                        energy += value * .25;
                        totalFire += value;
                        water -= value;
                    }
                    break;
                case "Medium":
                    if (value >= 51 && value <= 80 && water >= value) {
                        result[index++] = String.valueOf(value);
                        energy += value * .25;
                        totalFire += value;
                        water -= value;
                    }
                    break;
                case "Low":
                    if (value >= 1 && value <= 50 && water >= value) {
                        result[index++] = String.valueOf(value);
                        energy += value * .25;
                        totalFire += value;
                        water -= value;
                    }
                    break;
            }

            if (water <= 0) {
                break;
            }
        }

        System.out.println("Cells:");

        for (String res : result) {
            if (res != null) {
                System.out.printf(" - %s\n", res);
            }
        }

        System.out.println(String.format("Effort: %.2f", energy));
        System.out.println("Total Fire: " + totalFire);
    }
}
