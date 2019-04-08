package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class CookingFactory {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int highestTotalQuality = Integer.MIN_VALUE;
        int greaterAverageQuality = 0, shortestLength = 0;
        String batches;

        List<Integer> qualityList = new ArrayList<>();

        while (!"Bake It!".equals(batches = scan.nextLine())) {
            List<Integer> quality = Arrays.stream(batches.split("#"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int totalQuality = quality.stream().mapToInt(Integer::intValue).sum();

            if (totalQuality > highestTotalQuality) {
                highestTotalQuality = totalQuality;
                greaterAverageQuality = totalQuality / quality.size();
                shortestLength = quality.size();
                qualityList.clear();
                qualityList.addAll(quality);

            } else if (totalQuality == highestTotalQuality) {
                if (totalQuality / quality.size() > greaterAverageQuality) {
                    greaterAverageQuality = totalQuality / quality.size();
                    qualityList.clear();
                    qualityList.addAll(quality);

                } else if (totalQuality / quality.size() == greaterAverageQuality) {
                    if (quality.size() < shortestLength) {
                        shortestLength = quality.size();
                        qualityList.clear();
                        qualityList.addAll(quality);
                    }
                }
            }
        }

        System.out.printf("Best Batch quality: %d\n", highestTotalQuality);
        System.out.println(qualityList.toString().replaceAll("[\\[\\],]", ""));
    }
}
