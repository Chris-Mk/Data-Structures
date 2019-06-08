package Sets;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        String guests = scan.nextLine();
        while (!"PARTY".equals(guests)) {
            if (Character.isDigit(guests.charAt(0))) {
                vip.add(guests);
            } else {
                regular.add(guests);
            }
            guests = scan.nextLine();
        }

        String guestsWhoWent = scan.nextLine();
        while (!"END".equals(guestsWhoWent)) {

            if (vip.contains(guestsWhoWent)) {
                vip.remove(guestsWhoWent);
            } else {
                regular.remove(guestsWhoWent);
            }
            guestsWhoWent = scan.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
