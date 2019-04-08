package Arrays;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] houseMembers = scan.nextLine().split("@");

        int[] presents = new int[houseMembers.length];

        for (int i = 0; i < houseMembers.length; i++) {
            presents[i] = Integer.parseInt(houseMembers[i]);
        }

        int index = 0;
        String command;

        while (!"Merry Xmas!".equals(command = scan.nextLine())) {
            String[] data = command.split(" ");
            int jumpSteps = Integer.parseInt(data[1]);

            for (int i = 1; i <= jumpSteps; i++) {
                index++;

                if (index == presents.length) {
                    index = 0;
                }
            }

            if (presents[index] == 0) {
                System.out.printf("House %d will have a Merry Christmas.\n",index);
            } else {
                presents[index] -= 2;
            }
        }

        System.out.printf("Santa's last position was %d.\n", index);

        int houseCount = presents.length;
        for (int present : presents) {
            if (present == 0) {
                houseCount--;
            }
        }

        if (houseCount == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Santa has failed %d houses.\n", houseCount);
        }
    }
}
