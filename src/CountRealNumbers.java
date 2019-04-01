import java.text.DecimalFormat;
import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double[] nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> counts = new TreeMap<>();

        for (double num : nums) {
            counts.putIfAbsent(num, 0);

            int oldValue = counts.get(num);
            counts.put(num, oldValue + 1);
        }

        DecimalFormat pattern = new DecimalFormat("#.##");

        for (var entry : counts.entrySet()) {
            System.out.printf("%s -> %d\n", pattern.format(entry.getKey()), entry.getValue());
        }
    }
}
