package MultidimensionalArray;

public class DisplayingMultidimensionalArray {
    public static void main(String[] args) {

        int[][] firstArray = {{12, 21, 23}, {98, 89, 87}};
        int[][] secondArray = {{56, 65, 45}, {76, 34}, {9, 3, 34, 43, 83}};

        System.out.println("This is the first array:");
        for (int rows = 0; rows < firstArray.length; rows++) {
            for (int columns = 0; columns < firstArray[rows].length; columns++) {
                System.out.print(firstArray[rows][columns] + "\t");
            }
            System.out.println();
        }

        System.out.println("This is the second array:");
        for (int rows = 0; rows < secondArray.length; rows++) {
            for (int columns = 0; columns < secondArray[rows].length; columns++) {
                System.out.print(secondArray[rows][columns] + "\t");
            }
            System.out.println();
        }
    }
}
