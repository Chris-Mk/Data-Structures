package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeOrSkipRope {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String inputStr = scan.nextLine();
        List<Integer> numbers = new ArrayList<>();
        List<Character> newString = new ArrayList<>();

        for (int i = 0; i < inputStr.length(); i++) {
            if (Character.isDigit(inputStr.charAt(i))) {
                numbers.add(Integer.parseInt(String.valueOf(inputStr.charAt(i))));
            } else {
                newString.add(inputStr.charAt(i));
            }
        }

        int index = -1;
        List<Character> outputStr = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < numbers.get(i); j++) {
                    outputStr.add(newString.get(++index));
                }
            } else {
                for (int j = 0; j < numbers.get(i); j++) {
                    index++;
                }
            }
        }

        for (Character character : outputStr) {
            System.out.print(character);
        }
    }
}
