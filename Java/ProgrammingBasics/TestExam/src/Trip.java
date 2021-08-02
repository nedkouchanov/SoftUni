import java.util.Scanner;

public class Trip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double foodMoney = Double.parseDouble(scan.nextLine());
        double souvMoney = Double.parseDouble(scan.nextLine());
        double hotelMoney = Double.parseDouble(scan.nextLine());
        double benz = 54.39;
        double hotelFirst = hotelMoney * 0.9;
        double hotelSecond = hotelMoney * 0.85;
        double hotelThird = hotelMoney * 0.8;
        double hotelTotal = hotelFirst + hotelSecond + hotelThird;
        double total = (foodMoney * 3) + (souvMoney * 3) + hotelTotal + benz;
        System.out.printf("Money needed: %.2f", total);

    }
}
