import java.util.Scanner;

public class DisneyLandJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double journeyCost = Double.parseDouble(scan.nextLine());
        int months = Integer.parseInt(scan.nextLine());
        double everyMonth = journeyCost * 0.25;
        double totalMoney = 0;
        for (int i = 1; i <= months; i++) {
            if (i % 2 == 1) {
                if (i == 1) {
                } else {
                    totalMoney *= 0.84;
                }
            }
            if (i % 4 == 0) {
                totalMoney *= 1.25;
            }
            totalMoney += everyMonth;
        }
        double restNeed = Math.abs(totalMoney - journeyCost);
        if (journeyCost >= totalMoney) {
            System.out.printf("Sorry. You need %.2flv. more.", restNeed);
        } else {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", restNeed);
        }
    }
}
