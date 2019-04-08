package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasList {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> noisyKids = Arrays.stream(scan.nextLine().split("&"))
                .collect(Collectors.toList());

        String command;
        while (!"Finished!".equals(command = scan.nextLine())) {
            String[] data = command.split("\\s+");

            switch (data[0]) {
                case "Bad":
                    badKid(noisyKids, data[1]);
                    break;
                case "Good":
                    goodKid(noisyKids, data[1]);
                    break;
                case "Rename":
                    renameKid(noisyKids, data[1], data[2]);
                    break;
                case "Rearrange":
                    rearrangeKid(noisyKids, data[1]);
                    break;
            }
        }

        System.out.println(noisyKids.toString().replaceAll("[\\[\\]]", ""));
    }

    private static void rearrangeKid(List<String> noisyKids, String kidName) {
        for (int i = 0; i < noisyKids.size() - 1; i++) {
            if (kidName.equals(noisyKids.get(i))) {
                noisyKids.remove(kidName);
                noisyKids.add(kidName);
            }
        }
    }

    private static void renameKid(List<String> noisyKids, String firstName, String secondName) {
        for (int i = 0; i < noisyKids.size(); i++) {
            if (firstName.equals(noisyKids.get(i))) {
                noisyKids.set(i, secondName);
            }
        }
    }

    private static void goodKid(List<String> noisyKids, String kidName) {
        for (int i = 0; i < noisyKids.size(); i++) {
            if (kidName.equals(noisyKids.get(i))) {
                noisyKids.remove(kidName);
            }
        }
    }

    private static void badKid(List<String> noisyKids, String kidName) {
        boolean isPresent = false;

        for (String noisyKid : noisyKids) {
            if (kidName.equals(noisyKid)) {
                isPresent = true;
            }
        }

        if (!isPresent) {
            noisyKids.add(0, kidName);
        }
    }
}
