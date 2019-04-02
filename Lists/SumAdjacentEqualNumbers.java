package Lists;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Double> numbersList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbersList.size() - 1; i++) {
            if (numbersList.get(i).equals(numbersList.get(i + 1))) {
                numbersList.set(i, numbersList.get(i) + numbersList.get(i + 1));
                numbersList.remove(i + 1);
                i = -1;
            }
        }

        System.out.println(joinElementsByDelimiter(numbersList));
    }

    private static String joinElementsByDelimiter(List<Double> numbersList) {
        String output = "";

        for (Double number : numbersList) {
            output += (new DecimalFormat("0.#").format(number) + " ");
        }

        return output.trim();
    }
}
