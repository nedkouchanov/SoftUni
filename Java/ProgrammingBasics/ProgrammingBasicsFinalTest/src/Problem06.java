import java.util.Scanner;

public class Problem06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        String sport = scan.nextLine();
        String result = scan.nextLine();
        int cnt = 0;
        int winDays = 0;
        int loseDays = 0;
        double moneyDay = 0.0;
        while (days>cnt) {
            if (!sport.equals("Finish") && days > cnt) {
                moneyDay = 0.0;
                int win = 0;
                int lose = 0;
                if (result.equals("win")) {
                    moneyDay += 20;
                    win++;
                } else if (result.equals("lose")) {
                    moneyDay += 0;
                    lose++;
                }
                if (win > lose) {
                    moneyDay = moneyDay * 1.1;
                    winDays++;
                } else if (win < lose) {
                    loseDays++;
                }
                sport = scan.nextLine();
                if(sport.equals("Finish")){
                    cnt++;

                    continue;
                }
                result = scan.nextLine();
            } else {
                break;
            }
        }
        if (winDays > loseDays) {
            moneyDay = moneyDay * 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", moneyDay);
        } else if (winDays < loseDays) {
            System.out.printf("You lost the tournament! Total raised money: %.2f", moneyDay);
        }
    }
}

