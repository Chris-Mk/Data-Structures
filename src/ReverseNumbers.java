import java.util.*;

public class ReverseNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(stack::push);

        Collections.reverse(Arrays.asList(stack));
        System.out.println(stack.toString().replaceAll("[\\[\\],]", ""));
    }
}
