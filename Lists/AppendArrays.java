package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> numbersList = Arrays
                .stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();

        for (int i = 0; i < numbersList.size(); i++) {
            List<String> innerList= Arrays
                    .stream(numbersList.get(numbersList.size() - 1 - i).split("\\s+"))
                    .filter(e -> !e.equals(""))
                    .collect(Collectors.toList());

            result.addAll(innerList);
        }

        System.out.println(result.toString().replaceAll("[\\[\\],]",""));
    }
}
