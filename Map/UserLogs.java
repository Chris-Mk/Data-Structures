import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserLogs {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> logs = new TreeMap<>();

        Scanner scan = new Scanner(System.in);
        String input;

        while (!"end".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");
            String[] firstPart = data[0].split("=");
            String[] thirdPart = data[2].split("=");
            String ipAddress = firstPart[1];
            String userName = thirdPart[1];

            logs.putIfAbsent(userName, new LinkedHashMap<>());
            logs.get(userName).putIfAbsent(ipAddress, 0);
            logs.get(userName).put(ipAddress, logs.get(userName).get(ipAddress) + 1);
        }

        logs.forEach((user, addresses) -> {
            System.out.println(user + ": ");
            AtomicInteger counter = new AtomicInteger(1);

            addresses.forEach((address, count) -> {
                String format = String.format("%s => %d", address, count);

                if (counter.getAndIncrement() != addresses.size()) {
                    System.out.print(format + ", ");
                } else {
                    System.out.print(format + ".");
                }
            });
            System.out.println();
        });
    }
}
