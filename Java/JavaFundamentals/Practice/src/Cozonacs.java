import java.util.Scanner;

public class Cozonacs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        double oneKgFlour = Double.parseDouble(scan.nextLine());
        double eggPack = oneKgFlour * 0.75;
        double milkL = oneKgFlour * 1.25;
        double milkForOne = milkL / 4;
        int cozunacCnt = 0;
        int eggs = 0;
        double moneyForOneCozunac = oneKgFlour + eggPack + milkForOne;
        while (budget > 0) {
            budget -= moneyForOneCozunac;
            cozunacCnt++;
            eggs += 3;
            if (budget > 0) {
                if (cozunacCnt % 3 == 0) {
                    eggs -= (cozunacCnt - 2);
                }
            }
        }
        if (budget < 0) {
            budget += moneyForOneCozunac;
            cozunacCnt--;
            eggs -= 3;

        }
        System.out.println(String.format
                ("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", cozunacCnt, eggs, budget));
    }
}
