import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        double totalGrades = 0.0;
        double sbor = 0;
        int expCount = 0;
        int counter = 1;
        while (counter <= 12) {
            double note = Double.parseDouble(scan.nextLine());
            if (note >= 4) {
                counter++;
                totalGrades += note;
            } else {
                expCount++;
            }
            if (expCount == 2 ) {
                System.out.printf("%s has been excluded at %d grade", name, counter);
            }
        }
        double avarage = totalGrades / 12;
        System.out.printf("%s graduated. Average grade: %.2f", name, avarage);
    }
}
