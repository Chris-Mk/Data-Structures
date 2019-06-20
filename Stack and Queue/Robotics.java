import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(";");

        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            String name = data[0];
            int time = Integer.parseInt(data[1]);
            robots[i] = name;
            processTime[i] = time;
        }

        String[] startTime = scan.nextLine().split(":");
        int hours = Integer.parseInt(startTime[0]);
        int minutes = Integer.parseInt(startTime[1]);
        int seconds = Integer.parseInt(startTime[2]);

        int beginSeconds = hours * 3600 + minutes * 60 + seconds;
        ArrayDeque<String> products = new ArrayDeque<>();
        String inputProduct = scan.nextLine();

        while (!"End".equals(inputProduct)) {
            products.offer(inputProduct);
            inputProduct = scan.nextLine();
        }

        while (!products.isEmpty()) {
            beginSeconds++;
            String product = products.poll();
            boolean isAssigned = false;

            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isAssigned) {
                    workTime[i] = processTime[i];
                    isAssigned = true;
                    printRobotData(robots[i], product, beginSeconds);
                }

                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }

            if (!isAssigned) {
                products.offer(product);
            }
        }
    }

    private static void printRobotData(String robot, String product, int beginSeconds) {
        int seconds = beginSeconds % 60;
        int minutes = (beginSeconds / 60) % 60;
        int hours = (beginSeconds / 3600) % 24;

        System.out.println(String.format("%s - %s [%s]", robot, product,
                String.format("%02d:%02d:%02d", hours, minutes, seconds)));
    }
}
