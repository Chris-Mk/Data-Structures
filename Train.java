import java.util.Scanner;

public class Train {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String[] peopleArray = new String[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            String people = scan.nextLine();

            peopleArray[i] = people;
            sum += Integer.parseInt(people);
        }

        System.out.println(String.join(" ", peopleArray));
        System.out.println(sum);
    }
}
