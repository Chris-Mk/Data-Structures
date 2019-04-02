import java.util.Arrays;

public class ReversedArray {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int length = array.length;

        int[] reversedArray = new int[length];

        for (int index = 0; index < length; index++) {
            reversedArray[length - index - 1] = array[index];
        }
        System.out.println(Arrays.toString(reversedArray));
    }
}
