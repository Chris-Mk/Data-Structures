public class MaxPlatform2x2 {
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 2, 4, 0, 9, 5},
                {7, 1, 3, 3, 2, 1},
                {1, 3, 9, 8, 5, 6},
                {4, 6, 7, 9, 1, 0}
        };

        int maxSum = Integer.MIN_VALUE;
        int num1 = 0, num2 = 0, num3 = 0, num4 = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int cols = 0; cols < matrix[row].length - 1; cols++) {
                int sum = matrix[row][cols] + matrix[row][cols + 1] + matrix[row + 1][cols] + matrix[row + 1][cols + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    num1 = matrix[row][cols];
                    num2 = matrix[row][cols + 1];
                    num3 = matrix[row + 1][cols];
                    num4 = matrix[row + 1][cols + 1];
                }
            }
        }

        System.out.println("The best platform is:");
        System.out.printf("\t%d %d%n", num1, num2);
        System.out.printf("\t%d %d%n", num3, num4);
        System.out.println("The maximum sum is " + maxSum);
    }
}
