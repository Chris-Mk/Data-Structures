package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> resultantList = new ArrayList<>();
        int minSize = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < minSize; i++) {
            resultantList.add(firstList.get(i));
            resultantList.add(secondList.get(secondList.size() - 1 - i));
        }

        int start, end;
        if (firstList.size() > secondList.size()) {
            start = firstList.get(firstList.size() - 2);
            end = firstList.get(firstList.size() - 1);
        } else {
            start = secondList.get(0);
            end = secondList.get(1);
        }

        int begin = Math.min(start, end);
        int stop = Math.max(start, end);
        List<Integer> result = new ArrayList<>();

        for (Integer integer : resultantList) {
            if (integer > begin && integer < stop) {
                result.add(integer);
            }
        }

        Collections.sort(result);
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
