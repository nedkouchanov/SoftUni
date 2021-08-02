package SetAndMap;

import java.util.*;
import java.util.stream.Collectors;

public class Academy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Double> djendari = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());
        String name = scan.nextLine();
        double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        int times = grades.length;
        double currentAverage = 0;
        for (int i = 0; i < times; i++) {
            currentAverage += grades[i];
        }
        currentAverage /= times;
        while ((n-- > 0)) {
            djendari.put(name, currentAverage);
            if (n == 0) {
                break;
            }
            name = scan.nextLine();
            grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            currentAverage = 0;
            for (int i = 0; i < times; i++) {
                currentAverage += grades[i];
            }
            currentAverage /= times;
        }
        for (Map.Entry<String, Double> entry : djendari.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + entry.getValue());
        }
    }
}
