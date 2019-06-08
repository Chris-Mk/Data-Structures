import java.util.Scanner;

public class SnowBall {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int snowballs = Integer.parseInt(scan.nextLine());
        long snowballValueMax = 0;
        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;

        for (int i = 0; i < snowballs; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());

            long snowballValue = (long) Math.pow((snowballSnow / snowballTime), snowballQuality);

            if (snowballValue > snowballValueMax) {
                snowballValueMax = snowballValue;
                bestSnow = snowballSnow;
                bestTime = snowballTime;
                bestQuality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %d (%d)", bestSnow, bestTime, snowballValueMax, bestQuality);
    }
}
