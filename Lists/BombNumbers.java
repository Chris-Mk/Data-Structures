package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> elements = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String[] data = scan.nextLine().split("\\s+");
        String bombNumber = data[0];
        int power = Integer.parseInt(data[1]);

        while (elements.contains(bombNumber)) {
            int elementIndex = elements.indexOf(bombNumber);

            int left = Math.max(0 , elementIndex - power);
            int right = Math.min(elementIndex + power, elements.size() - 1);

            if (right >= left) {
                elements.subList(left, right + 1).clear();
            }
        }

        System.out.println(elements.stream().mapToInt(Integer::parseInt).sum());
    }
}
