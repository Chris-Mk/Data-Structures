public class IntroToArrays {
    public static void main(String[] args) {

        int[] numbers = {12,21,23,32,34,43,534};
        System.out.println("Index\tValue");

        //prints indices and elements in the array
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(i + "\t\t" + numbers[i]);
        }
        System.out.println();

        //prints the sum of all elements
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum = " + sum);

        //prints the element with the largest value
        int max = numbers[0];
        for (int number: numbers) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println("The largest number is " + max);
    }
}
