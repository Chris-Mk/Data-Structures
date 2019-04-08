package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MemoryView {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input;

        while (!"Visual Studio crash".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");

            String message = "";
            for (int i = 0; i < data.length; i++) {
                if (!data[i].equals("32656") &&
                    !data[i].equals("19759") &&
                    !data[i].equals("32763") &&
                    data[i].length() > 1) {
                    message += (char) Integer.parseInt(data[i]);
                }
            }

            if (!message.isEmpty()) {
                System.out.println(message);
            }
        }
    }
}
