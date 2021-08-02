import java.util.Scanner;

public class XpGain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double xpNeeded = Double.parseDouble(scan.nextLine());
        double totalXp = 0.0;
        boolean flag = false;
        int battlesCnt = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= battlesCnt; i++) {
            double xpEarnedPerBat = Double.parseDouble(scan.nextLine());
            if (i % 3 == 0) {
                xpEarnedPerBat = xpEarnedPerBat * 1.15;
            }
            else if (i % 5 == 0) {
                xpEarnedPerBat = xpEarnedPerBat * 0.9;
            }
            totalXp += xpEarnedPerBat;
            if (totalXp >= xpNeeded) {
                System.out.println(String.format
                        ("Player successfully collected his needed experience for %d battles.", i));
                flag = true;
                break;
            }
        }
        if (!flag) {
            double need = xpNeeded - totalXp;
            System.out.println(String.format
                    ("Player was not able to collect the needed experience, %.2f more needed.", need));
        }
    }
}
