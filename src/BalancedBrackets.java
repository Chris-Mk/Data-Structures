import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int countOpen = 0;
        int countClose = 0;
        String lastBracket = "";

        while (n-- > 0) {
            String str = scan.nextLine();

            if (str.length() == 1){
                if (str.equals("(")){
                    countOpen++;
                    lastBracket = str;
                }

                if (str.equals(")")){
                    countClose++;
                    lastBracket = str;
                }

                if (Math.abs(countOpen - countClose) > 1){
                    System.out.println("UNBALANCED");
                    return;
                }
            }
        }

        if (Math.abs(countOpen - countClose) > 0 || lastBracket.equals("(")){
            System.out.println("UNBALANCED");
        }else {
            System.out.println("BALANCED");
        }
    }
}