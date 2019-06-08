package MultidimensionalArray;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[][] chessBoard = new String[8][8];

        for (int i = 0; i < 8; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            System.arraycopy(tokens, 0, chessBoard[i], 0, 8);
        }

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j].equals("q")) {
                    if (isValidQueen(chessBoard[i][j], chessBoard)) {
                        System.out.println(i + " " + j);
                    }
                }
            }
        }
    }

    private static boolean isValidQueen(String queen, String[][] chessBoard) {
        boolean isValid = true;

        for (int i = 0; i < chessBoard.length; i++) {

        }
        return isValid;
    }
}
