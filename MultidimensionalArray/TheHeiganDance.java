package MultidimensionalArray;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double damage = Double.parseDouble(scan.nextLine());
        int[][] chamber = new int[15][15];
        int xPos = 7, yPos = 7;
        double player = 18500;
        double heigan = 3000000;
        int cloudCount = 0;

        String input = scan.nextLine();
        while (player > 0 || heigan > 0) {
            heigan -= damage;

            String[] data = input.split("\\s+");
            String spell = data[0];
            int spellRow = Integer.parseInt(data[1]);
            int spellCol = Integer.parseInt(data[2]);


            if (spell.equals("Cloud")) {
                if (cloudCount == 2) {
                    cloudCount = 0;
                }
                player -= 3500;
                cloudCount++;
            }

            if (spell.equals("Eruption")) {
                player -= 6000;
            }
            input = scan.nextLine();
        }
    }
}
