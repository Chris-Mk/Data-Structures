import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int plants = Integer.parseInt(scan.nextLine());
        int[] pesticide = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> pesticideAmount = new ArrayList<>();
        for (int i = 0; i < plants; i++) {
            pesticideAmount.add(pesticide[i]);
        }

        int days = 0;
        for (int i = 0; i < pesticideAmount.size() - 1; i++) {
            List<Integer> indices = new ArrayList<>();

            for (int j = i + 1; j < pesticideAmount.size(); j++) {
                if (pesticideAmount.get(i++) < pesticideAmount.get(j)) {
                    indices.add(pesticideAmount.get(j));
                }
            }

            if (indices.isEmpty()) {
                break;
            }

            for (Integer index : indices) {
                pesticideAmount.remove(index);
            }
            days++;
            i = -1;
        }
        System.out.println(days);
    }
}
