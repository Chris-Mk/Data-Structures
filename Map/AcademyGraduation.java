import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scan.nextLine());
        Map<String, Double[]> graduationList = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scan.nextLine();
            String[] scoreString = scan.nextLine().split("\\s+");
            Double[] scores = new Double[scoreString.length];

            for (int j = 0; j < scoreString.length; j++) {
                scores[j] = Double.parseDouble(scoreString[j]);
            }
            graduationList.putIfAbsent(name, scores);
        }

        graduationList.forEach((student, scores) -> {
            System.out.printf("%s is graduated with ", student);
            double sum = 0d;

            for (Double score : scores) {
                sum += score;
            }
            System.out.print(sum / scores.length);
            System.out.println();
        });
    }
}
