package Lists;

import java.util.*;

public class ChatLogger {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> messages = new ArrayList<>();

        String input = scan.nextLine();

        while (!"end".equals(input)) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Chat":
                    messages.add(command[1]);
                    break;
                case "Delete":
                    messages.remove(command[1]);
                    break;
                case "Edit":
                    int index = messages.indexOf(command[1]);
                    messages.set(index, command[2]);
                    break;
                case "Pin":
                    messages.remove(command[1]);
                    messages.add(command[1]);
                    break;
                case "Spam":
                    messages.addAll(Arrays.asList(command).subList(1, command.length));
                    break;
            }

            input = scan.nextLine();
        }

        for (String message : messages) {
            System.out.println(message);
        }
    }
}
