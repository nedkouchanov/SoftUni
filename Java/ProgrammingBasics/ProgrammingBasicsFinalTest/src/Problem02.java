import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        double skiPrice = Double.parseDouble(scan.nextLine());
        double shtekaPrice = Double.parseDouble(scan.nextLine());
        double skiBoots = skiPrice * 0.4;
        double skiClothes = skiPrice * 1.4;
        double total = skiBoots + skiClothes + skiPrice;
        if (total > 800) {
            shtekaPrice = 0;
        }
        total = skiBoots + skiClothes + skiPrice + shtekaPrice;
        double moneyNeed = Math.abs(money - total);
        if (total < money) {
            System.out.printf("Angel's sum is %.2f lv. He has %.2f lv. left.", total, moneyNeed);
        } else if (total >= money) {
            System.out.printf("Not enough money! You need %.2f leva more!", moneyNeed);
        }


    }
}
