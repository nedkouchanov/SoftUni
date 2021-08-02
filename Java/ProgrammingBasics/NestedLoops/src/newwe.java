import java.util.Scanner;

public class newwe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        String sport = scan.nextLine();
        int totalWINDays = 0;
        int totalLOSTDays = 0;
        double totalMoney = 0.0;
        double moneyForDay = 0.0;
        int cnt = 0;
        int winDay = 0;
        int lostDay = 0;
        while ((!sport.equals("Finish")) || days > cnt) {
            if (sport.equals("Finish")) {
                sport = scan.nextLine();
            }
            double moneyForPlay = 0.0;
            String result = scan.nextLine();
            if (result.equals("win")) {
                moneyForPlay = 20;
                winDay++;
            } else if (result.equals("lose")) {
                lostDay++;
            }
            moneyForDay += moneyForPlay;
            sport = scan.nextLine();
            if (sport.equals("Finish")) {
                if (winDay > lostDay) {
                    moneyForDay = moneyForDay * 1.1;
                    totalWINDays++;
                    winDay = 0;
                } else if (winDay < lostDay) {
                    totalLOSTDays++;
                    lostDay = 0;
                }
                totalMoney += moneyForDay;
                moneyForDay = 0.0;
                cnt++;
            }
        }
        if (totalWINDays > totalLOSTDays) {
            totalMoney = totalMoney * 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoney);
        } else if (totalWINDays < totalLOSTDays) {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoney);
        }
    }
}
