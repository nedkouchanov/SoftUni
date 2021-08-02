package SetAndMap;

import java.util.*;
import java.util.stream.Collectors;

public class AvarageGrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentsWithGrades = new TreeMap<>();
        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            studentsWithGrades.putIfAbsent(name, new ArrayList<>());
            studentsWithGrades.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : studentsWithGrades.entrySet()) {
            System.out.println(String.format("%s -> %s (avg: %.2f)", entry.getKey(),
                    getGradesAsString(entry.getValue()), getAvarage(entry.getValue())));
        }
    }

    private static double getAvarage(List<Double> grades) {
        return grades
                .stream()
                .mapToDouble(g -> g)
                .average()
                .orElse(0.0);
    }

    private static String getGradesAsString(List<Double> grades) {
        return grades
                .stream()
                .map((grade -> String.format("%.2f", grade)))
                .collect(Collectors.joining(" "));
    }
}
