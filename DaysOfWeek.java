import java.util.Scanner;

public class DaysOfWeek {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int day = Integer.parseInt(scan.nextLine());
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (day > 0 && day <= 7) {
            System.out.println(days[day - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
