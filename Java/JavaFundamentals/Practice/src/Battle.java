import java.util.Scanner;

public class Battle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double expNeeded = Double.parseDouble(scan.nextLine());
        double expGained = 0;
        boolean flag = true;
        int battles = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= battles; i++) {
            double expPerBattle = Double.parseDouble(scan.nextLine());
            if (i % 3 == 0) {
                expPerBattle *= 1.15;
            } else if (i % 5 == 0) {
                expPerBattle *= 0.9;
            }
            expGained += expPerBattle;
            if (expGained >= expNeeded) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", i);
                flag = false;
                break;

            }

        }
        if (flag) {
            double need = expNeeded - expGained;
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", need);
        }
    }
}
