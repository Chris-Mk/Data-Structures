package MultidimensionalArray;

public class Oranges {
    public static void main(String[] args) {
        int[][] firstArray = {{1, 2}, {3, 4}};
        int[][] secondArray = {{5, 6}, {7}, {8, 9}};

       System.out.println("This is the first array");
       display(firstArray);
       System.out.println("This is the second array");
       display(secondArray);
    }

    private static void display(int[][] x) {
        for(int row = 0; row < x.length; row++) {
            for (int column = 0; column < x[row].length; column++){
                System.out.print(x[row][column] +"\t");
            }
            System.out.println();
        }
    }
}
