import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int pokePower = Integer.parseInt(scan.nextLine());
        int targetDistance = Integer.parseInt(scan.nextLine());
        int exhaustionFactor = Integer.parseInt(scan.nextLine());
        int targetsPoked = 0;
        int halfPower = (pokePower * 50) / 100;

        while (pokePower >= targetDistance) {
            targetsPoked++;
            pokePower -= targetDistance;

            if (pokePower == halfPower) {
                pokePower /= exhaustionFactor;
            }
        }

        System.out.println(halfPower);
        System.out.println(pokePower);
        System.out.println(targetsPoked);
    }
}
