import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double[] nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> counts = new LinkedHashMap<>();

        for (double num : nums) {
            counts.putIfAbsent(num, 0);

            int oldValue = counts.get(num);
            counts.put(num, oldValue + 1);
        }

        for (var entry : counts.entrySet()) {
            System.out.printf("%.1f -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
