package Sets;

import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {

        HashSet<String> cars = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        String input;

        while (!"END".equals(input = scan.nextLine())) {
            String[] data = input.split(", ");

            switch (data[0]) {
                case "IN" -> cars.add(data[1]);
                case "OUT" -> cars.remove(data[1]);
            }
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            cars.forEach(System.out::println);
        }
    }
}
