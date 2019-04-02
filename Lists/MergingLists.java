package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> firstList = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> secondList = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();

        int minSize = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < minSize; i++) {
            result.add(firstList.get(i));
            result.add(secondList.get(i));
        }

        if (firstList.size() > secondList.size()) {
            result.addAll(firstList.subList(minSize, firstList.size()));
        } else {
            result.addAll(secondList.subList(minSize, secondList.size()));
        }
        System.out.println(result.toString().replaceAll("[\\[,\\]]", ""));
    }
}
