import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {

        Map<String, Map<String, Integer>> logs = new TreeMap<>();
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String ip = data[0];
            String user = data[1];
            int time = Integer.parseInt(data[2]);
            logs.putIfAbsent(user, new TreeMap<>());
            logs.get(user).putIfAbsent(ip, 0);
            logs.get(user).put(ip, logs.get(user).get(ip) + time);
        }

        logs.forEach((user, address) -> System.out.println(String.format("%s: %d [%s]",
                user,
                address.values().stream().mapToInt(Integer::intValue).sum(),
                String.join(", ", address.keySet()))));
    }
}
