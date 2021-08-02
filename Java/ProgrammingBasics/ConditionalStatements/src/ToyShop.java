import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceExc = Double.parseDouble(scan.nextLine());
        int puzzleNum = Integer.parseInt(scan.nextLine());
        int dollsNum = Integer.parseInt(scan.nextLine());
        int teddyBNum = Integer.parseInt(scan.nextLine());
        int minionsNum = Integer.parseInt(scan.nextLine());
        int trucksNum = Integer.parseInt(scan.nextLine());

        double puzzlePrice = puzzleNum * 2.6;
        double dollsPrice = dollsNum * 3;
        double teddyBPrice = teddyBNum * 4.1;
        double minionsPrice = minionsNum * 8.2;
        double trucksPrice = trucksNum * 2;

        int orderedToys = puzzleNum + dollsNum +
                teddyBNum + minionsNum + trucksNum;
        double price = puzzlePrice + dollsPrice +
                teddyBPrice + minionsPrice + trucksPrice;
        if (orderedToys >= 50) {
            price = price * 0.75;
        }
        double priceFinal = price * 0.9;
        double extra = priceFinal-priceExc;
        double need = priceExc-priceFinal;
        if (priceFinal >= priceExc) {
            System.out.printf("Yes! %.2f lv left.", extra);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.",need);
        }
    }
}
