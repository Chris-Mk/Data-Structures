import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] numberArray = scan.nextLine().split(" ");

        int rotations = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rotations; i++) {
            String temp = numberArray[0];

            for (int j = 0; j < numberArray.length - 1; j++) {
                numberArray[j] = numberArray[j + 1];
            }

            numberArray[numberArray.length - 1] = temp;
        }

        System.out.println(String.join(" ", numberArray));
    }
}
