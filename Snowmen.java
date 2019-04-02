import java.util.Arrays;
import java.util.Scanner;

public class Snowmen {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] snowmen = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int arrayLength = snowmen.length;
        int counter = 0, attacker;

        while (arrayLength > 1) {

            for (int i = 0; i < arrayLength; i++) {
                counter++;
                attacker = snowmen[i];

                if (snowmen[i] > arrayLength) {
                    snowmen[i] %= arrayLength;
                }

                int diff = Math.abs(snowmen[i] - i);
                if (snowmen[i] == i){
                    System.out.printf("%d performed harakiri\n", i);
                    break;
                } else if (diff % 2 == 0) {
                    System.out.printf("%d x %d -> %d wins\n", i , snowmen[i], i);
                } else if (diff % 2 != 0) {
//TODO
                    continue;
                }

                if (attacker != snowmen[i]) {
                    snowmen[i] = attacker;
                }
            }

            arrayLength -= counter;
            counter = 0;
        }
    }
}
