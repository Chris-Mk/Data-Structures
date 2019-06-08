import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double biggestVolume = 0;
        String biggestKeg = "";

        for (int i = 0; i < n; i++) {
            String kegModel = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());

            double volume = Math.PI * radius * radius * height;

            if (volume > biggestVolume) {
                biggestVolume = volume;
                biggestKeg = kegModel;
            }
        }

        System.out.println(biggestKeg);
    }
}
