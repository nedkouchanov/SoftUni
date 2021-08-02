import java.util.Scanner;

public class BonusScoring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int studentsCnt = Integer.parseInt(scan.nextLine());
        int lecturesCnt = Integer.parseInt(scan.nextLine());
        int bonus = Integer.parseInt(scan.nextLine());
        double biggest = 0.0;
        int biggestAtt = 0;
        for (int i = 0; i < studentsCnt; i++) {
            int currAttend = Integer.parseInt(scan.nextLine());
            double currTotalBonus = (double) currAttend / lecturesCnt * (5 + bonus);
            if (currTotalBonus > biggest) {
                biggest = currTotalBonus;
                biggestAtt = currAttend;
            }
        }
        biggest = Math.round(biggest);
        System.out.println(String.format("Max Bonus: %.0f.", biggest));
        System.out.println(String.format("The student has attended %d lectures.", biggestAtt));
    }
}
