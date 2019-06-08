import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        int elevatorCapacity = Integer.parseInt(scan.nextLine());

        int quotient = (int) Math.ceil((double) people / elevatorCapacity);

        System.out.println(quotient);
    }
}